package com.hgb.collectionandmap.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huang.guangbing
 * @since 2024/9/16
 */
public class ArraryListDemo {
    public static void main(String[] args) {

        List<Integer> arraryList = new ArrayList<>();
        arraryList.add(1);

        for (int i = 2; i < 11; i++) {
            arraryList.add(i);
        }
        arraryList.add(11);
        final Object[] objects = arraryList.toArray();
        System.out.println(arraryList);
    }
}
