package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException, NullPointerException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandpaName = reader.readLine();
        Cat catGrandpa = new Cat(grandpaName);

        String grandmaName = reader.readLine();
        Cat catGrandma = new Cat(grandmaName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, null, catGrandpa);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, catGrandma);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catMother, catFather);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother, catFather);


        System.out.println(catGrandpa);
        System.out.println(catGrandma);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat mother) {
            this.name = name;
            this.mother = mother;
        }

        Cat(String name, Cat mother, Cat father){
            this.name = name;
            if (mother != null)
                this.mother = mother;
            this.father = father;
        }


        @Override
        public String toString() {
            if (mother == null && father == null)
                return "Cat name is " + name + ", no mother "+ ", no father ";
            else {
                if (father == null)
                    return "Cat name is " + name + ", mother is " + mother.name + ", no father ";
                else {
                    if (mother == null)
                        return "Cat name is " + name + ", no mother "+", father is " + father.name;
                    else
                    return "Cat name is " + name + ", mother is " + mother.name + ", father is " + father.name;
                }
            }
        }
    }

}
