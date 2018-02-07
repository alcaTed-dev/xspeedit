package com.alcated.xspeedit;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;



public class App {

    public static final int CAPACITY = 10;

    public static void main(String[] args) {
        Objects.requireNonNull(args);
        if (args.length != 1) throw new IllegalArgumentException();
        String decision = args[0];
        if (!decision.matches("\\d+")) throw new IllegalArgumentException();

        List<Item> items = Stream.of(decision.split(""))
                .map(Integer::parseInt)
                .map(Item::of)
                .collect(toList());

        PackingChainSolver packingChainSolver = new PackingChainSolver(items, CAPACITY);
        PackingChain packingChain = packingChainSolver.solve();
        PackingChainPrinter packingChainPrinter = new PackingChainPrinter(packingChain);

        System.out.println(packingChainPrinter.print());
    }
}
