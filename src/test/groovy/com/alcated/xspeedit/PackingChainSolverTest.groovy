package com.alcated.xspeedit

import spock.lang.Specification

class PackingChainSolverTest extends Specification {
    def "Solve"() {
        given:
        def boxCapacity = 10
        def items = [Item.of(1), Item.of(6), Item.of(3),
                     Item.of(8), Item.of(4), Item.of(1),
                     Item.of(6), Item.of(8), Item.of(9),
                     Item.of(5), Item.of(2), Item.of(5),
                     Item.of(7), Item.of(7), Item.of(3)
        ]
        def solver = new PackingChainSolver(items, boxCapacity)

        when:
        def packingChain = solver.solve()

        then:
        packingChain.getBoxes().size() == 8
    }
}
