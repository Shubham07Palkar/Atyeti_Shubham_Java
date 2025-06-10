package com.Collections.BehavioralQuestions.HashSet;
//Duplicate Custom Objects with same Data

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class User{
    int id;
    String email;

    public User(String email, int id) {
        this.email = email;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) return true;
        if(!(obj instanceof User)) return false;
        User other = (User) obj;
        return id == other.id && Objects.equals(email, other.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", id=" + id +
                '}';
    }
}

public class TestHashSets {
    public static void main(String[] args) {
        Set<User> users = new HashSet<>();
        users.add(new User("a@gmail.com",1));
        users.add(new User("a@gmail.com",1));
        users.add(new User("b@gmail.com", 2));

        System.out.println(users);
    }
}
