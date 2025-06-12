package com.Collections.BehavioralQuestions.HashSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TagRelationshipManager {

    private static Map<String, Set<String>> buildTagMap(Set<Set<String>> tagRelations) {
        Map<String, Set<String>> tagMap = new HashMap<>();

        for(Set<String> group : tagRelations){
            for (String tag : group){
                tagMap.putIfAbsent(tag, new HashSet<>());

                for (String related : group){
                    if (!related.equals(tag)){
                        tagMap.get(tag).add(related);
                    }
                }
            }
        }
        return tagMap;
    }


    public static void main(String[] args) {
        Set<Set<String>> tagRelations = Set.of(
                Set.of("Java", "Spring", "Backend"),
                Set.of("Python", "ML"),
                Set.of("Spring", "Cloud"),
                Set.of("ML", "AI"),
                Set.of("Java", "Microservices")
        );
        Map<String, Set<String>> result = buildTagMap(tagRelations);

        for (Map.Entry<String, Set<String>> entry:result.entrySet()){
            System.out.println(entry.getKey()+" -> "+entry.getValue());
        }
    }
}
