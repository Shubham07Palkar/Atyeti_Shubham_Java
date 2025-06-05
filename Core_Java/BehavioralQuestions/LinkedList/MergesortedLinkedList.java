package com.Collections.BehavioralQuestions.LinkedList;

import java.util.LinkedList;

public class MergesortedLinkedList {
    public static LinkedList<Integer> merge(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedList<Integer> result = new LinkedList<>();
        while (!l1.isEmpty() && !l2.isEmpty()) {
            result.add(l1.peekFirst() <= l2.peekFirst() ? l1.pollFirst() : l2.pollFirst());
        }
        result.addAll(l1);
        result.addAll(l2);
        return result;
    }

    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        l1.add(1);
        l1.add(3);
        l1.add(5);
        l2.add(2);
        l2.add(4);
        l2.add(6);

        System.out.println(merge(l1, l2));
    }
}
