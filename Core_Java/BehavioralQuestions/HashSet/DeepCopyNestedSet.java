package com.Collections.BehavioralQuestions.HashSet;

import java.util.HashSet;
import java.util.Set;

public class DeepCopyNestedSet {
    public static void main(String[] args) {
        Set<Set<String>> original = new HashSet<>();
        original.add(new HashSet<>(Set.of("Java", "Spring")));
        original.add(new HashSet<>(Set.of("Python", "ML")));

        Set<Set<String>> copied = deepCopy(original);
        copied.iterator().next().add("NewTag");
        System.out.println(original);
        System.out.println(copied);
    }

    private static Set<Set<String>> deepCopy(Set<Set<String>> original) {
        Set<Set<String>> copy = new HashSet<>();
        for (Set<String> inner:original){
            Set<String> innerCopy = new HashSet<>(inner);
            copy.add(innerCopy);
        }
        return copy;
    }
}
