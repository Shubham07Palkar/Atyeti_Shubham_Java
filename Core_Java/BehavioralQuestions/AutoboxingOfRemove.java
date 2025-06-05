package com.Collections.BehavioralQuestions;

import java.util.ArrayList;
import java.util.List;

public class AutoboxingOfRemove {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i= -1; i <=3; i++){
            list.add(i);
        }
        System.out.println("Original List "+list);

        list.remove(1);
        System.out.println("After remove(1) "+list);

        list.remove(Integer.valueOf(1));
        System.out.println("After removing valueOf(1) "+list);
    }
}
//remove(int index) removes the element at the given position.

//remove(Object o) removes the first occurrence of the value.