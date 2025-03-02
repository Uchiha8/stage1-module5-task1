package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> list != null && list.stream().allMatch(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            if (list != null) {
                List<Integer> evenValues = list.stream()
                        .filter(x -> x % 2 == 0)
                        .toList(); // Collect even numbers
                list.addAll(evenValues); // Append them to the list
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream()
                .filter(s -> Character.isUpperCase(s.charAt(0))) // Starts with uppercase
                .filter(s -> s.endsWith(".")) // Ends with '.'
                .filter(s -> s.split(" ").length > 3) // More than 3 words
                .collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> list.stream()
                .collect(Collectors.toMap(s -> s, String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> result = new ArrayList<>(list1);
            result.addAll(list2);
            return result;
        };
    }
}
