package com.alcated.xspeedit;

import java.util.stream.Collectors;

public class PackingChainPrinter {

    private PackingChain packingChain;

    public PackingChainPrinter(PackingChain packingChain) {
        this.packingChain = packingChain;
    }

    public String print() {
        return this.packingChain.getBoxes().stream()
                .map(box -> box.getItems()
                        .stream()
                        .map(Item::getSize)
                        .map(String::valueOf)
                        .collect(Collectors.joining()))
                .collect(Collectors.joining("/"));

    }
}
