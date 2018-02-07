package com.alcated.xspeedit;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.Collections.unmodifiableCollection;

public class PackingChain {
    private final Collection<Box> boxes;

    private PackingChain(Collection<Box> boxes) {
        this.boxes = unmodifiableCollection(boxes);
    }

    public Collection<Box> getBoxes() {
        return boxes;
    }

    public static final class PackingChainBuilder {
        private Collection<Box> boxes = new ArrayList<>();

        private PackingChainBuilder() {
        }

        public static PackingChainBuilder aPackingChain() {
            return new PackingChainBuilder();
        }

        public PackingChainBuilder withBoxes(Collection<Box> boxes) {
            this.boxes = boxes;
            return this;
        }

        public PackingChain build() {
            return new PackingChain(boxes);
        }
    }
}
