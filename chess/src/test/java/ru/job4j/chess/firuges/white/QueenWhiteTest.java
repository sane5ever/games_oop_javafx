package ru.job4j.chess.firuges.white;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.chess.Board;
import ru.job4j.chess.exeptions.ImpossibleMoveException;
import ru.job4j.chess.exeptions.OccupiedWayException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class QueenWhiteTest {
    private final Board board = new Board();

    @Before
    public void prepare() {
        this.board.add(new QueenWhite(Cell.C3));
        this.board.add(new QueenWhite(Cell.E5));
    }

    @Test
    public void whenAllowedMoveForward() {
        boolean result = this.board.move(Cell.C3, Cell.C5);
        assertThat(result, is(true));
    }

    @Test
    public void whenAllowedMoveLeft() {
        boolean result = this.board.move(Cell.E5, Cell.A5);
        assertThat(result, is(true));
    }

    @Test
    public void whenDiagonalMoveForwardThenTrue() {
        boolean result = this.board.move(Cell.C3, Cell.D4);
        assertThat(result, is(true));
    }

    @Test
    public void whenWayNotEmpty() {
        boolean result;
        try {
            result = this.board.move(Cell.E5, Cell.B2);
        } catch (OccupiedWayException owe) {
            result = false;
        }
        assertThat(result, is(false));
    }

    @Test
    public void whenForbiddenMove() {
        boolean result;
        try {
            result = this.board.move(Cell.E5, Cell.G6);
        } catch (ImpossibleMoveException ime) {
            result = false;
        }
        assertThat(result, is(false));
    }
}
