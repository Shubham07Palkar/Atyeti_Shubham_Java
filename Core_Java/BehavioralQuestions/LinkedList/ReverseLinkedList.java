package com.Collections.BehavioralQuestions.LinkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ReverseLinkedList {

    public static LinkedList<Integer> reverse(LinkedList<Integer> original){
        LinkedList<Integer> reversed = new LinkedList<>();
        ListIterator<Integer> it = original.listIterator(original.size());

        while(it.hasPrevious()){
            reversed.add(it.previous());
        }
        return reversed;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(60);
        list.add(40);
        list.add(20);

        System.out.println("Original: "+ list);
        LinkedList<Integer> reversed = reverse(list);
        System.out.println("Reversed: "+ reversed);
    }
}
