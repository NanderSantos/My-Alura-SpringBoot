package courses.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class SizeComparator {

    public static void main(String[] args) {

        List<String> words = new ArrayList<>();
        words.add("Nander");
        words.add("Nander Santos");
        words.add("Nander Carmo");
        words.add("Nander Santos do Carmo");

        OrderBySize order = new OrderBySize();
        PrintByLine printer = new PrintByLine();

        words.sort(order);
        words.forEach(printer);
    }
}

class OrderBySize implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {

        if(o1.length() > o2.length()) return 1;
        if(o1.length() < o2.length()) return -1;
        return 0;
    }
}

class PrintByLine implements Consumer<String> {

    @Override
    public void accept(String s) {

        System.out.println(s);
    }
}