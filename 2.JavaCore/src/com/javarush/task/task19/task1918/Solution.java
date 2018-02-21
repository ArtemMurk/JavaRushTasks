package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        // считываю файл в String str
        FileReader fileR = new FileReader(fileName);
        StringBuffer buffer = new StringBuffer();
        while (fileR.ready()){
            int ch = fileR.read();
            buffer.append((char) ch);
        }
        String str = buffer.toString();
        fileR.close();


        //cоздаю 2 листа с индексами начала и конца строк
        ArrayList<Integer> listEnd = new ArrayList<>();
        ArrayList<Integer> listStart = new ArrayList<>();

        // ругулярка определяет или тег открытия, или тег закрытия. (<tag someText> | </tag>)
        String regOpenTag1 = "<("+args[0]+")>";
        String regOpenTag2 ="<("+args[0]+")[ \\n]+"+"?[[[a-zA-Z_0-9][ \\t\\n\\x0B\\f\\r]][^>]]+>";
        String regClosedTag = "</"+args[0]+">";
        String regExp= regOpenTag2+"|"+regOpenTag1+"|"+regClosedTag;
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        while (m.find()) { //
            if (m.group().equals("</"+args[0]+">")){ //если тег закрытия
                listEnd.add(m.end()); //заношу индекс конца сторки
            }
            else {
                listStart.add(m.start()); // если тег открытия заношу индекс начала строки
            }
            if(listStart.size()==listEnd.size()&& listStart.size()>0){ // если количество тегов(ткрытия,закрытия равно)
                while(listStart.size()!=0){ //печатаем выражения беря индексы начала и конца, снимаем обвертки удаляя начальные и конечные индексы.
                    String s = str.substring(listStart.get(0),listEnd.get(listEnd.size()-1));
                    if (!s.equals(""))System.out.println(s);
                    listStart.remove(0);
                    listEnd.remove(listEnd.size()-1);//соответсвенно в конце получаем пустой список
                }
            }
        }


    }
}
