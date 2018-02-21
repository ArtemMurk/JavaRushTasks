package com.javarush.task.task20.task2002;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("txt", null, new File("/home/artem/"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            User artem = new User();
            artem.setFirstName("Artem");
            artem.setLastName("Serg");
            artem.setBirthDate(new Date(1990,4,5));
            artem.setMale(true);
            artem.setCountry(User.Country.UKRAINE);
            javaRush.users.add(artem);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            System.out.println(javaRush.equals(loadedObject));
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            String ifUserExist = users != null ? "yes" : "no";
            writer.println(ifUserExist);
            if (users != null){
                writer.println(users.size());
                for (User userTmp: users) {
                    writer.println(userTmp.getFirstName());
                    writer.println(userTmp.getLastName());
                    writer.println(userTmp.getBirthDate().getTime());
                    writer.println(userTmp.isMale());
                    writer.println(userTmp.getCountry().getDisplayedName());

                }
            }
            writer.flush();
            writer.close();
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String ifUserExist = reader.readLine();
            if (ifUserExist.equals("yes")){
                int userCounter = Integer.parseInt(reader.readLine());
                for (int i = 0; i < userCounter ; i++) {

                    User newUser = new User();
                    String firstName = reader.readLine();
                    String lastName = reader.readLine();
                    Date birthDate =new Date(Long.parseLong(reader.readLine()));
                    boolean isMale = Boolean.parseBoolean(reader.readLine());
                    String country = reader.readLine();

                    newUser.setFirstName(firstName);
                    newUser.setLastName(lastName);
                    newUser.setBirthDate(birthDate);
                    newUser.setMale(isMale);
                    if (country.equals("Ukraine")){
                        newUser.setCountry(User.Country.UKRAINE);
                    }
                    else
                        if (country.equals("Russia")){
                        newUser.setCountry(User.Country.RUSSIA);
                        }
                        else newUser.setCountry(User.Country.OTHER);

                    users.add(newUser);
                }
                reader.close();

            }

            //implement this method - реализуйте этот метод
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
