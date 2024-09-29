package com.hgb.collectionandmap.stream;

import java.util.stream.Stream;

/**
 * @author huang.guangbing
 * @since 2024/9/24
 */
public class StreamApi {
    public static void main(String[] args) {
        System.out.println(
            Stream.of("green", "yellow", "blue").max((s1, s2) -> s1.compareTo(s2))
            .filter(s->s.endsWith("n"))
            .orElse("yellowq")
        );
    }
}
