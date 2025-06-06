package com.Collections.BehavioralQuestions.HashMap;

import java.util.HashMap;
import java.util.Map;

class Key{
    int id;
    Key(int id){
        id= this.id;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Key) && this.id == ((Key)obj).id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Key("+id+")";
    }
}

public class mutatingKeyDemo {
    public static void main(String[] args) {
        Map<Key, String> map = new HashMap<>();
        Key key = new Key(1);
        map.put(key,"value");

        key.id = 2;

        System.out.println(map.get(new Key(1)));
        System.out.println(map.get(key));
    }
}
