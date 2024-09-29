package com.hgb.collectionandmap.io;

import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author huang.guangbing
 * @since 2024/9/24
 */
public class IODemo {
    public static void main(String[] args) throws FileNotFoundException {
        //final BufferedReader aaa = new BufferedReader(new FileReader("aaa"));
        //
        ////final BufferedReader bufferedReader = new BufferedReader(new File(""));
        //
        //final FileReader fileReader = new FileReader("aaa");
        //final BufferedReader bufferedReader = new BufferedReader("aaa");
        //
        ////Math.abs

        Supplier<String> i = () -> "Car";
        Consumer<String> c = x -> System.out.println(x.toLowerCase());
        Consumer<String> d = x -> System.out.println(x.toUpperCase());
        c.andThen(d).accept(i.get());
        System.out.println(
        );

        int a = 9,b=2;
        float f;
        f= a/b;
        System.out.println(f);
        f = f/2;
        System.out.println(f);
        f= a+ b/f;
        System.out.println(f);

        ResourceBundle.getBundle("Message", new Locale("zh", "CN"));
    }
}
