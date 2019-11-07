package ru.job4j.chess.figures.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;

public class BishopBlackTest {
    @Test
    public void whenPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell result = bishopBlack.position();
        Assert.assertEquals(result, Cell.C1);
    }

    @Test
    public void whenCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Figure result = bishopBlack.copy(Cell.F4);
        Assert.assertEquals(result.position(), Cell.F4);
    }

    @Test
    public void whenWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.C1, Cell.G5);
        Assert.assertThat(result, is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test
    public void whenDiagonalTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        boolean result = bishopBlack.isDiagonal(Cell.G5, Cell.C1);
        Assert.assertThat(result, is(true));
    }

    @Test
    public void whenDiagonalFalse() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        boolean result = bishopBlack.isDiagonal(Cell.G5, Cell.C2);
        Assert.assertThat(result, is(false));
    }
}
