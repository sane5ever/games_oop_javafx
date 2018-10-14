package ru.job4j.chess.firuges.white;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.chess.Board;
import ru.job4j.chess.exeptions.ImpossibleMoveException;
import ru.job4j.chess.exeptions.OccupiedWayException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PawnWhiteTest {
    private final Board board = new Board();

    @Before
    public void prepare() {
        this.board.add(new PawnWhite(Cell.B2));
    }

    @Test
    public void whenAllowedMoveForward() {
        boolean result = this.board.move(Cell.B2, Cell.B3);
        assertThat(result, is(true));
    }

    @Test
    public void whenForbiddenMoveBackward() {
        boolean result;
        try {
            result = this.board.move(Cell.B2, Cell.B1);
        } catch (ImpossibleMoveException ime) {
            result = false;
        }
        assertThat(result, is(false));
    }

    @Test
    public void whenForbiddenMoveLeft() {
        boolean result;
        try {
            result = this.board.move(Cell.B2, Cell.A2);
        } catch (ImpossibleMoveException ime) {
            result = false;
        }
        assertThat(result, is(false));
    }

    @Test
    public void whenWayNotEmpty() {
        boolean result;
        this.board.add(new PawnWhite(Cell.B3));
        try {
            result = this.board.move(Cell.B2, Cell.B3);
        } catch (OccupiedWayException owe) {
            result = false;
        }
        assertThat(result, is(false));
    }
}
