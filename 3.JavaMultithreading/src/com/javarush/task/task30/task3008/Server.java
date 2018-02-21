package com.javarush.task.task30.task3008;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
         int port = ConsoleHelper.readInt();
        try (ServerSocket ss = new ServerSocket(port)){
            System.out.println("Сервер Запущен");
            while (true) {
                Socket socket = ss.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void sendBroadcastMessage(Message message){
        for (Map.Entry<String,Connection> pair: connectionMap.entrySet()) {
            try {
                pair.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Не смогли отправить сообщение");
            }
        }
    }

    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            while (true)
            {
                //Отправляем сообщение с запросом имени
                connection.send(new Message(MessageType.NAME_REQUEST));
                //Получаем ответ
                Message answer = connection.receive();
                if (answer.getType() == MessageType.USER_NAME){               //Если ответ пришел с именем пользователя
                    if (!answer.getData().isEmpty()){                         //Если ответ пришел не пустым
                        if(!connectionMap.containsKey(answer.getData()))      //Если этого имени нет в карте
                        {
                            connectionMap.put(answer.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return answer.getData();
                        }
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException{

            for (Map.Entry<String, Connection> pair: connectionMap.entrySet()) {
                if (!pair.getKey().equals(userName)){
                    Message userAdded = new Message(MessageType.USER_ADDED, pair.getKey());
                    connection.send(userAdded);
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true){
             Message messageTextrec = connection.receive();
             if (messageTextrec.getType() == MessageType.TEXT){
                 Message messageText = new Message(MessageType.TEXT,userName+": "+messageTextrec.getData());
                 sendBroadcastMessage(messageText);
             }
             else ConsoleHelper.writeMessage("Данное сообщение не текстового типа, повторите отправку.");

            }
        }

        @Override
        public void run() {
            String userName = null;
            ConsoleHelper.writeMessage("Установлено новое соединение с адрессом:"+socket.getRemoteSocketAddress());
            try( Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED,userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e ){
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с серевером");

            }
            finally {
                if (userName != null){
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED,userName));
                }
                ConsoleHelper.writeMessage("Соединение закрыто.");

            }


        }
    }
}
