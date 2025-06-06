package com.Collections.BehavioralQuestions.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sublistPitfall {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Amsterdam", "Boston", "Chicago", "Denmark", "England"));

        List<String> subList = list.subList(1,4);
        System.out.println(subList + "sublist");

        list.add("Finland");

        try{
            subList.get(0); //accessing sublist throws concurrentModificationsException
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }

        //new list
        List<String> safecopy = new ArrayList<>(list.subList(1,4));
    }
}
//modifying original list structurally the sublist becomes invalid (Add, Remove)
//safe - convert it to new list

