package com.Collections.BehavioralQuestions.HashSet;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class FlattenNestedTest {


    @Test
    public void testFlatten(){
        Set<Set<String>> nested = Set.of(
                Set.of("A", "B"),
                Set.of("B", "C"),
                Set.of("D")
        );
        Set<String> result = FlattenNested.flattenset(nested);
        assertEquals(Set.of("A", "B", "C", "D"), result);
    }

    @Test
    public void testEmptyOuterSet(){
        Set<Set<String>> nested = Set.of();
        Set<String> result = FlattenNested.flattenset(nested);
        assertTrue(result.isEmpty());
    }
}