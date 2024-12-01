package org.example.year2024.day1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Admin on 12/1/2024
 * @project advent-of-code
 * @package org.example.year2024.day1
 * @contact @sarvargo
 */
public class PartOne {
    public static void main(String[] args) throws IOException {
        // Read input from a file
        File file = new File("2024/day1.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        // Prepare lists to dynamically store numbers
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            String[] numbers = line.trim().split("\\s+");
            list1.add(Integer.parseInt(numbers[0]));
            list2.add(Integer.parseInt(numbers[1]));
        }
        br.close();

        List<Integer> result = new ArrayList<>();

        list1.sort(Integer::compareTo);
        list2.sort(Integer::compareTo);

        while (!list1.isEmpty()) {
            Integer i1 = list1.get(0);
            Integer i2 = list2.get(0);
            result.add(i1 >= i2 ? i1 - i2 : i2 - i1);
            list2.remove(0);
            list1.remove(0);
        }

        int sum = result.stream().mapToInt(item -> item).sum();
        System.out.println(sum);
    }
}
