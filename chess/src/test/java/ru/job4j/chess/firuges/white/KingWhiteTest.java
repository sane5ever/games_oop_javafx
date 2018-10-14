package ru.job4j.chess.firuges.white;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.chess.Board;
import ru.job4j.chess.exeptions.ImpossibleMoveException;
import ru.job4j.chess.exeptions.OccupiedWayException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class KingWhiteTest {
    private final Board board = new Board();

    @Before
    public void prepare() {
        this.board.add(new KingWhite(Cell.C3));
    }

    @Test
    public void whenAllowedMoveForward() {
        boolean result = this.board.move(Cell.C3, Cell.C4);
        assertThat(result, is(true));
    }

    @Test
    public void whenAllowedMoveBackward() {
        boolean result = this.board.move(Cell.C3, Cell.C2);
        assertThat(result, is(true));
    }

    @Test
    public void whenAllowedMoveLeft() {
        boolean result = this.board.move(Cell.C3, Cell.C2);
        assertThat(result, is(true));
    }

    @Test
    public void whenAllowedMoveRight() {
        boolean result = this.board.move(Cell.C3, Cell.C4);
        assertThat(result, is(true));
    }

    @Test
    public void whenDiagonalMoveForwardThenTrue() {
        boolean result = this.board.move(Cell.C3, Cell.D4);
        assertThat(result, is(true));
    }

    @Test
    public void whenDiagonalMoveBackwardThenTrue() {
        boolean result = this.board.move(Cell.C3, Cell.B2);
        assertThat(result, is(true));
    }

    @Test
    public void whenWayNotEmpty() {
        this.board.add(new KingWhite(Cell.D4));
        boolean result;
        try {
            result = this.board.move(Cell.C3, Cell.D4);
        } catch (OccupiedWayException owe) {
            result = false;
        }
        assertThat(result, is(false));
    }

    @Test
    public void whenForbiddenMoveForward() {
        boolean result;
        try {
            result = this.board.move(Cell.C3, Cell.C5);
        } catch (ImpossibleMoveException ime) {
            result = false;
        }
        assertThat(result, is(false));
    }

    @Test
    public void whenForbiddenMoveBackward() {
        boolean result;
        try {
            result = this.board.move(Cell.C3, Cell.A5);
        } catch (ImpossibleMoveException ime) {
            result = false;
        }
        assertThat(result, is(false));
    }

}
