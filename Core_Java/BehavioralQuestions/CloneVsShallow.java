package com.Collections.BehavioralQuestions;

import java.util.ArrayList;

class Person{
    String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class CloneVsShallow {
    public static void main(String[] args) {
        ArrayList<Person> originalList = new ArrayList<>();
        originalList.add(new Person("RRR"));
        originalList.add(new Person("Ram charan"));

        //shallow copy
        ArrayList<Person> shallowCopy = (ArrayList<Person>) originalList.clone();

        //modifying original
        originalList.get(0).name = "NTR updated";

        System.out.println(originalList + "Original List");
        System.out.println(shallowCopy+"shallow Copy");
    }
}

//modifying original element in original list also effercts the shallow copy.
// clone performs a shallow copy - the list structure is new but objects inside are shared.

