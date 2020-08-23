package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {
        Figure bishopBlack = new BishopBlack(Cell.A1);
        assertThat(bishopBlack.position(),is(Cell.A1));
    }

    @Test
    public void copy() {
        Figure bishopBlack = new BishopBlack(Cell.A1);
        Figure copyFigure = bishopBlack.copy(Cell.A1);
        assertThat(copyFigure.position(),is(Cell.A1));
    }

    @Test
    public void way() throws ImpossibleMoveException {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] wayFigure = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(expected,is(wayFigure));
    }

    @Test(expected = IllegalStateException.class)
    public void wayInvalid() throws ImpossibleMoveException {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.G6);
    }

}