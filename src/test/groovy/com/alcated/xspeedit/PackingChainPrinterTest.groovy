package com.alcated.xspeedit

import spock.lang.Specification

import static com.alcated.xspeedit.Box.BoxBuilder.aBox
import static com.alcated.xspeedit.Item.of
import static com.alcated.xspeedit.PackingChain.PackingChainBuilder.aPackingChain
import static java.util.Arrays.asList

class PackingChainPrinterTest extends Specification {
    def "Print"() {
        given:
        def packingChain = aPackingChain()
                .withBoxes(asList(
                aBox().withCapacity(0)
                        .withItems(asList(of(1), of(6), of(3)))
                        .build(),
                aBox().withCapacity(1)
                        .withItems(asList(of(8), of(1)))
                        .build(),
                aBox().withCapacity(0)
                        .withItems(asList(of(4), of(6)))
                        .build(),
                aBox().withCapacity(1)
                        .withItems(asList(of(9)))
                        .build(),
                aBox().withCapacity(0)
                        .withItems(asList(of(8), of(2)))
                        .build(),
                aBox().withCapacity(0)
                        .withItems(asList(of(5), of(5)))
                        .build(),
                aBox().withCapacity(3)
                        .withItems(asList(of(7)))
                        .build(),
                aBox().withCapacity(0)
                        .withItems(asList(of(7), of(3)))
                        .build(),
        )).build()

        def printer = new PackingChainPrinter(packingChain)

        when:
        def result = printer.print()

        then:
        result == "163/81/46/9/82/55/7/73"

    }
}
