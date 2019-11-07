package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;

public class LogicTest {
    @Test
    public void whenMoveTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Logic logic = new Logic();
        logic.add(bishopBlack);
        boolean result = logic.move(Cell.C1, Cell.G5);
        Assert.assertThat(result, is(true));
    }

    @Test
    public void whenMoveFalseInEnd() {
        BishopBlack bishopBlack1 = new BishopBlack(Cell.G5);
        BishopBlack bishopBlack2 = new BishopBlack(Cell.C1);
        Logic logic = new Logic();
        logic.add(bishopBlack1);
        logic.add((bishopBlack2));
        boolean result = logic.move(Cell.G5, Cell.C1);
        Assert.assertThat(result, is(false));
    }

    @Test
    public void whenMoveFalseInMiddle() {
        BishopBlack bishopBlack1 = new BishopBlack(Cell.B7);
        BishopBlack bishopBlack2 = new BishopBlack(Cell.D5);
        Logic logic = new Logic();
        logic.add(bishopBlack1);
        logic.add((bishopBlack2));
        boolean result = logic.move(Cell.B7, Cell.G2);
        Assert.assertThat(result, is(false));
    }
}
