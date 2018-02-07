package com.alcated.xspeedit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;

import static com.alcated.xspeedit.Box.BoxBuilder.aBox;
import static com.alcated.xspeedit.PackingChain.PackingChainBuilder.aPackingChain;

public class PackingChainSolver {

    private final Collection<Item> items;
    private final int boxCapacity;

    public PackingChainSolver(Collection<Item> items, int boxCapacity) {
        this.items = items;
        this.boxCapacity = boxCapacity;
    }

    public PackingChain solve() {
        Collection<Box> boxes = new ArrayList<>();
        Consumer<Item> addInExistingBoxOrInANewONe = item -> {
            Optional<Box> foundBox = boxes.stream()
                    .filter(box -> box.fit(item))
                    .findFirst();
            if (foundBox.isPresent()) {
                Box box = foundBox.get();
                boxes.remove(box);
                boxes.add(box.add(item));
            } else {
                Box box = aBox()
                        .withCapacity(boxCapacity)
                        .build();
                boxes.add(box.add(item));
            }
        };
        items.forEach(addInExistingBoxOrInANewONe);

        return aPackingChain().withBoxes(boxes).build();
    }
}
