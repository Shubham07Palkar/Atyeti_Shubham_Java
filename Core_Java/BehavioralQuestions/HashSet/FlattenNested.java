package com.Collections.BehavioralQuestions.HashSet;

import java.util.HashSet;
import java.util.Set;

public class FlattenNested {
    public static void main(String[] args) {
        Set<Set<String>> nestedTags = Set.of(
                Set.of("Java", "Spring"),
                Set.of("Spring", "Cloud"),
                Set.of("Python", "ML"),
                Set.of("Java", "ML")
        );
        Set<String> result = flattenset(nestedTags);
        System.out.println("Flattened Tags: "+ result);
    }

    public static Set<String> flattenset(Set<Set<String>> nestedTags) {
        Set<String> flattened = new HashSet<>();
        for(Set<String> group: nestedTags){
            flattened.addAll(group);
        }
        return flattened;
    }
}
