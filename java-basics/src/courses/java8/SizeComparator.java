package courses.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SizeComparator {

    public static void main(String[] args) {

        List<String> words = new ArrayList<>();
        words.add("Nander");
        words.add("Nander Santos");
        words.add("Nander Carmo");
        words.add("Nander Santos do Carmo");

//        words.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
//        words.sort(Comparator.comparing(word -> word.length()));
        words.sort(Comparator.comparing(String::length));
        words.sort(Comparator.comparing((word -> -word.length())));

//        words.forEach(word -> System.out.println(word));
        words.forEach(System.out::println);
    }
}