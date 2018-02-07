package com.alcated.xspeedit

import spock.lang.Specification

import static com.alcated.xspeedit.Box.BoxBuilder.aBox
import static com.alcated.xspeedit.Item.of

class BoxTest extends Specification {
    def "Item fits in the box"() {
        given:
        def box4 = aBox()
                .withCapacity(4)
                .build()
        def item = of(4)

        when:
        def fit = box4.fit(item)

        then:
        fit
    }

    def "Item does not fit in the box"() {
        given:
        def box = aBox()
                .withCapacity(4)
                .build()
        def item = of(5)

        when:
        def fit = box.fit(item)

        then:
        !fit
    }

    def "Adding an item creates a new Box"() {
        given:
        def box = aBox()
                .withCapacity(4)
                .build()
        def item = of(4)

        when:
        def newBox = box.add(item)

        then:
        newBox != box
        newBox.getCapacity() == box.getCapacity() - item.getSize()
    }

}