package ru.job4j.chess.firuges.white;

import ru.job4j.chess.exeptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class QueenWhite extends Figure {
    public QueenWhite(Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] result;
        try {
            result = source.x != dest.x && source.y != dest.y
                    ? new BishopWhite(source).way(source, dest)
                    : new RookWhite(source).way(source, dest);
        } catch (ImpossibleMoveException ime) {
            throw new ImpossibleMoveException("Queen moves wrong!");
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QueenWhite(dest);
    }
}