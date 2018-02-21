package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }


//    public boolean equals(Object n)
//    {
//
//        if (n==null)
//            return false;
//        if (n.getClass() != this.getClass() )
//            return false;
//
//        Solution eqSol = (Solution) n;
//
//        if(this == eqSol) return true;
//
//        if (eqSol.first ==null && eqSol.last==null)
//            return false;
//
//        return eqSol.first.equals(first) && eqSol.last.equals(last);
//    }

//    public int hashCode() {
//
//        return first != null? 31 * first.hashCode() : 0 + last != null? last.hashCode():0 ;
//    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        for (Solution sf: s) {
            System.out.println(sf.hashCode());
        }
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
