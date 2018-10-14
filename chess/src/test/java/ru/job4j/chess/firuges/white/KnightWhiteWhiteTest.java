package ru.job4j.chess.firuges.white;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.chess.Board;
import ru.job4j.chess.exeptions.ImpossibleMoveException;
import ru.job4j.chess.exeptions.OccupiedWayException;
import ru.job4j.chess.firuges.Cell;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class KnightWhiteWhiteTest {
    private final Board board = new Board();

    @Before
    public void prepare() {
        this.board.add(new KnightWhite(Cell.C3));
        this.board.add(new KnightWhite(Cell.C4));
    }

    @Test
    public void whenAllowedMoveForwardRight() {
        boolean result = this.board.move(Cell.C3, Cell.D5);
        assertThat(result, is(true));
    }

    @Test
    public void whenAllowedMoveForwardLeft() {
        boolean result = this.board.move(Cell.C3, Cell.B5);
        assertThat(result, is(true));
    }

    @Test
    public void whenAllowedMoveBackwardRight() {
        boolean result = this.board.move(Cell.C4, Cell.D2);
        assertThat(result, is(true));
    }

    @Test
    public void whenAllowedMoveBackwardLeft() {
        boolean result = this.board.move(Cell.C4, Cell.D2);
        assertThat(result, is(true));
    }

    @Test
    public void whenForbiddenMove() {
        boolean result;
        try {
            result = this.board.move(Cell.C3, Cell.E5);
        } catch (ImpossibleMoveException ime) {
            result = false;
        }
        assertThat(result, is(false));
    }

    @Test
    public void whenDestNotEmpty() {
        this.board.add(new KnightWhite(Cell.D6));
        boolean result;
        try {
            result = this.board.move(Cell.C4, Cell.D6);
        } catch (OccupiedWayException owe) {
            result = false;
        }
        assertThat(result, is(false));
    }
}
