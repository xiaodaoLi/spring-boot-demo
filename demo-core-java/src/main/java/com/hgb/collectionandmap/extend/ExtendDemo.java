package com.hgb.collectionandmap.extend;

import java.io.ByteArrayOutputStream;
import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author huang.guangbing
 * @since 2024/9/24
 */
public class ExtendDemo {
    static String message;

    public static void main(String[] args) {
        //Parent parent = new Child1();
        //final Child1 parent1 = (Child1) parent;
        //final Child1 child1 = new Child1();
        //
        //Parent parent2 = new Parent();
        //final Child1 parent21 = (Child1) parent2;
        //parent21.tes();

        final LocalDate localDate = LocalDate.of(
            2015, 4, 4
        );

        System.out.println(localDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy")));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("E, MMM dd, yyyy")));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("MM/dd/yy")));


        try {
            message = test();
        } catch (Exception e) {
            message += "F";
            System.out.println(message);
        } finally {
            System.out.println(message);
        }

        Double d = null;
        System.out.println(d instanceof Double);
        int c = 0;
        System.out.println(0 == c++);

        String s = "1";
        System.out.println("1" != s);

        boolean b = false;
        System.out.println(b = true);

        byte c1[] = {10, 20, 30, 40, 50};
        byte c2[] = {60, 70, 80, 90};
        ByteArrayOutputStream b1 = new ByteArrayOutputStream();
        ByteArrayOutputStream b2 = new ByteArrayOutputStream(10);
        b2.write(100);
        System.out.println("o1 " + b2.size());

        b2.write(c1, 0, c2.length);
        System.out.println("02 " + b2.size());

        final Locale locale = new Locale("English", "US");
        //final Locale locale1 = new Locale(Locale.ENGLISH);
        final Locale english = new Locale("ENGLISH");
        //final Locale locale1 = new Locale(Locale.ENGLISH, Locale.US);
        //final Locale locale1 = new Locale();

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add(0, "3");
        list.add(1, "4");
        list.forEach(System.out::println);

        Long l = new Long(1234);
        Long l1 = l;
        if (l1 == l) {
            System.out.println("equals");
        }
        else {
            System.out.println("not");
        }
        l++;
        if (l1 == l) {
            System.out.println("equals");
        }
        else {
            System.out.println("not");
        }

        try {
            double[] limits = {1,2,3};
            String[] strArray = {"{2}", "{2}", "{2}"};
            ChoiceFormat choiceFormat = new ChoiceFormat(limits, strArray);
            Format[] formatArray = {choiceFormat, null, NumberFormat.getInstance()};
            MessageFormat messageFormat = new MessageFormat("{0} out of {2}");
            messageFormat.setFormats(formatArray);
            Object[] testArgs = {null, "2", null};
            for (int i = 0; i < 4; i++) {
                testArgs[0] = new Integer(i);
                testArgs[2] = testArgs[0];
                System.out.println(messageFormat.format(testArgs));
            }
        }
        catch (Exception e) {
            System.out.println(e.getClass());
        }
    }

    public static String test() throws Exception {
        String str = "A";
        try {
            throw new Exception();
        } catch (Exception e) {
            try {
                try {
                    throw new Exception();
                } catch (Exception ex) {
                    str += "B";
                }
                throw new Exception();
            } catch (Exception e1) {
                str += "C";
            } finally {
                str += "D";
            }
        } finally {
            str += "E";
        }
        return str;

    }
}

class Parent {

    public void tes() {
        System.out.println("parent");
    }
}

class Child1 extends Parent {

    @Override
    public void tes() {
        System.out.println("child1");
    }
}

class Child2 extends Parent {

}
