package com.Collections.BehavioralQuestions.Streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamReuseDemo {
    public static void main(String[] args) {
        String[] names = {"Anime", "Thriller", "Action", "Drama"};

        Stream<String> nameStream = Arrays.stream(names);

        //First Terminal Operation
        nameStream.forEach(name -> System.out.println(name.toUpperCase()));

        //Reusing terminal op. will throw exception
        nameStream.forEach(name -> System.out.println(name.toUpperCase()));
//        |

        //Trying to reuse it throws IllegalStateException.
    }
}
