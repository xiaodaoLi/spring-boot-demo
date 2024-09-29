package com.hgb.collectionandmap.extend;

import java.io.*;
import java.util.*;

public class SystemManager {
    private static String initString;

    static {
        String currentString = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("E:\\code\\spring-boot-demo\\demo-core-java\\src\\main\\java\\com\\hgb\\collectionandmap\\extend\\aaa.txt"));
            initString = reader.lines().findFirst().orElse(null);
        } catch (IOException ex) {
            throw new NoSuchElementException("File initconfig.txt");
        }
    }

    public SystemManager() {
        if (initString.length() == 0) {
            throw new IllegalArgumentException("length is zero");
        }
        System.out.println("It works!");
    }

    public static void main(String[] args) {
        SystemManager myClass = new SystemManager();
    }
}
