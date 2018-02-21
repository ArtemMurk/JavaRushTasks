package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
//        out.writeObject(fileName);
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        fileName = (String) in.readObject();

        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);

    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {

        Solution solution = new Solution("/home/artem/primer1.txt");

        solution.writeObject("Artem");
        FileOutputStream fileOutput = new FileOutputStream("/home/artem/primer2.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        outputStream.writeObject(solution);

        FileInputStream fis = new FileInputStream("/home/artem/primer2.txt");
        ObjectInputStream inputStream = new ObjectInputStream(fis);

        Solution solution2 = (Solution) inputStream.readObject();
        solution.close();
//        solution2.close();
        outputStream.close();
        inputStream.close();

    }
}
