package ru.job4j.chess.firuges.white;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.chess.Board;
import ru.job4j.chess.exeptions.ImpossibleMoveException;
import ru.job4j.chess.exeptions.OccupiedWayException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopWhiteTest {
    private final Board board = new Board();

    @Before
    public void prepare() {
        this.board.add(new BishopWhite(Cell.B2));
        this.board.add(new BishopWhite(Cell.D4));
    }

    @Test
    public void whenAllowedMoveForward() {
        boolean result = this.board.move(Cell.B2, Cell.C3);
        assertThat(result, is(true));
    }

    @Test
    public void whenAllowedMoveBackward() {
        boolean result = this.board.move(Cell.B2, Cell.A3);
        assertThat(result, is(true));
    }

    @Test
    public void whenForbiddenMove() {
        boolean result;
        try {
            result = this.board.move(Cell.B2, Cell.B5);
        } catch (ImpossibleMoveException ime) {
            result = false;
        }
        assertThat(result, is(false));
    }

    @Test
    public void whenWayNotEmpty() {
        boolean result;
        try {
            result = this.board.move(Cell.B2, Cell.E5);
        } catch (OccupiedWayException owe) {
            result = false;
        }
        assertThat(result, is(false));
    }
}