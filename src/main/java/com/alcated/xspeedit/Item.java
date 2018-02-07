package com.alcated.xspeedit;

public final class Item {
    private final int size;

    private Item(int size) {
        this.size = size;
    }

    public static Item of(int size) {
        return new Item(size);
    }

    public int getSize() {
        return size;
    }
}