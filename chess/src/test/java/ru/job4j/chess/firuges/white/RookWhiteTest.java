package ru.job4j.chess.firuges.white;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.chess.Board;

import ru.job4j.chess.exeptions.ImpossibleMoveException;
import ru.job4j.chess.exeptions.OccupiedWayException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RookWhiteTest {
    private final Board board = new Board();

    @Before
    public void prepare() {
        this.board.add(new RookWhite(Cell.B2));
        this.board.add(new RookWhite(Cell.B5));
    }

    @Test
    public void whenAllowedMoveForward() {
        boolean result = this.board.move(Cell.B2, Cell.B4);
        assertThat(result, is(true));
    }

    @Test
    public void whenAllowedMoveBackward() {
        boolean result = this.board.move(Cell.B5, Cell.B3);
        assertThat(result, is(true));
    }

    @Test
    public void whenAllowedMoveLeft() {
        boolean result = this.board.move(Cell.B5, Cell.D5);
        assertThat(result, is(true));
    }

    @Test
    public void whenAllowedMoveRight() {
        boolean result = this.board.move(Cell.B2, Cell.A2);
        assertThat(result, is(true));
    }

    @Test
    public void whenWayNotEmpty() {
        boolean result;
        try {
            result = this.board.move(Cell.B5, Cell.B1);
        } catch (OccupiedWayException owe) {
            result = false;
        }
        assertThat(result, is(false));
    }

    @Test
    public void whenDiagonalMoveForwardThenFalse() {
        boolean result;
        try {
            result = this.board.move(Cell.B5, Cell.C6);
        } catch (ImpossibleMoveException ime) {
            result = false;
        }
        assertThat(result, is(false));
    }

    @Test
    public void whenDiagonalMoveBackwardThenFalse() {
        boolean result;
        try {
            result = this.board.move(Cell.B5, Cell.A4);
        } catch (ImpossibleMoveException ime) {
            result = false;
        }
        assertThat(result, is(false));
    }
}
