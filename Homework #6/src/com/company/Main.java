package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Homework #6
 *
 * @author Sheritari (Severgin Andrey)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        UsersRepositoryFileImpl newRep = new UsersRepositoryFileImpl("in.txt");
        User user = newRep.findById(2);
        System.out.println(user);
        user.setAge(23);
        user.setName("Марсель");
        newRep.update(user);
    }
}
