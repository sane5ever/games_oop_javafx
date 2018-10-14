package ru.job4j.chess.firuges.white;

import ru.job4j.chess.exeptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class KnightWhite extends Figure {
    public KnightWhite(Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (isNotL(source, dest)) {
            throw new ImpossibleMoveException("Knight moves wrong!");
        }
        return new Cell[]{dest};
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightWhite(dest);
    }

    private boolean isNotL(Cell source, Cell dest) {
        return Math.abs(source.x - dest.x) + Math.abs(source.y - dest.y) != 3;
    }
}