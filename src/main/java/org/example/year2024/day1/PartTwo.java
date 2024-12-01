package org.example.year2024.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Admin on 12/1/2024
 * @project advent-of-code
 * @package org.example.year2024.day1
 * @contact @sarvargo
 */
public class PartTwo {
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
        List<Long> result = new ArrayList<>();
        for (Integer i : list1) {
            long count = list2.stream().filter(item -> item.equals(i)).count();
            result.add(i * count);
        }

        System.out.println(result.stream().mapToLong(item -> item).sum());
    }
}
