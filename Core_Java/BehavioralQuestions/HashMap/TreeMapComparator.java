package com.Collections.BehavioralQuestions.HashMap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapComparator {
    public static void main(String[] args) {
        Map<String, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());

        treeMap.put("Banana", 10);
        treeMap.put("Apple", 20);
        treeMap.put("Cherry", 15);

        System.out.println(treeMap);
    }
}
