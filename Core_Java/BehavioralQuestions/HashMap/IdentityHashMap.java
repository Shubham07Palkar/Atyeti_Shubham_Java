package com.Collections.BehavioralQuestions.HashMap;

import java.util.Map;

public class IdentityHashMap {

    public static void main(String[] args) {
        Map<String, String> map = new java.util.IdentityHashMap<>();

        String k1 = new String("Key");
        String k2 = new String("Key");

        map.put(k1, "value1");
        map.put(k2, "value2");

        System.out.println("Size: "+map.size());

    }

}
