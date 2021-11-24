package com.company;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class UsersRepositoryFileImpl {
    String file;

    UsersRepositoryFileImpl() {
    }

    UsersRepositoryFileImpl(String path) {
        this.file = path;
    }

    User findById(int id) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            list.add(line);
        }
        reader.close();
        for (String s : list) {
            if (s.startsWith(id + "|")) {
                return new User(s);
            }
        }
        throw new IllegalArgumentException("Такого id нет в файле");
    }

    void update(User user) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            list.add(line);
        }
        for (String s : list) {
            if (s.startsWith(user.getId() + "|")) {
                list.remove(s);
                list.add(user.toString());
                break;
            }
        }
        reader.close();
        try {
            Files.delete(Path.of(file));
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", file);
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n", file);
        } catch (IOException x) {
            // File permission problems are caught here.
            System.err.println(x);
        }
        File f = new File(file);
        FileWriter writer = new FileWriter(f);
        for (String s : list) {
            writer.write(s + "\n");
        }
        writer.close();
    }
}
