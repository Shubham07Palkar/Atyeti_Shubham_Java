package com.Collections.BehavioralQuestions.LinkedList;

import java.util.*;

public class RemoveEverySecond {
    public static void removealternate(LinkedList<String> list){
        Iterator<String> it = list.iterator();
        boolean remove = false;

        while(it.hasNext()){
            it.next();
            if (remove)it.remove();
            remove =!remove;
        }
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("String","Integer","Boolean", "Float"));
        LinkedList<String> linkedList = new LinkedList<>(names);
        removealternate(linkedList);
        System.out.println(linkedList);
    }
}
