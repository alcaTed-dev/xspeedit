package com.alcated.xspeedit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static com.alcated.xspeedit.Box.BoxBuilder.aBox;
import static java.util.Collections.unmodifiableCollection;

public final class Box {
    private final int capacity;
    private final Collection<Item> items;


    private Box(int capacity, Collection<Item> items) {
        this.capacity = capacity;
        this.items = unmodifiableCollection(items);
    }

    public int getCapacity() {
        return capacity;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public Box add(Item item) {
        Collection<Item> items = new ArrayList<>(this.items);
        items.add(item);

        return aBox()
                .withCapacity(capacity - item.getSize())
                .withItems(items)
                .build();
    }

    public boolean fit(Item item) {
        return capacity >= item.getSize();
    }

    @Override
    public String toString() {
        return "Box{" +
                "capacity=" + capacity +
                ", items=" + Arrays.toString(items.toArray()) +
                '}';
    }

    public static final class BoxBuilder {
        private int capacity;
        private Collection<Item> items = new ArrayList<>();

        public static BoxBuilder aBox() {
            return new BoxBuilder();
        }

        public BoxBuilder withCapacity(int remainingCapacity) {
            this.capacity = remainingCapacity;
            return this;
        }

        public BoxBuilder withItems(Collection<Item> items) {
            this.items = items;
            return this;
        }

        public Box build() {
            return new Box(this.capacity, this.items);
        }

    }

}