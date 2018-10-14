package ru.job4j.chess.firuges.white;

import ru.job4j.chess.exeptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class RookWhite extends Figure {
    public RookWhite(Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (source.x != dest.x && source.y != dest.y) {
            throw new ImpossibleMoveException("Rook moves wrong!");
        }
        int size = Math.max(Math.abs(source.x - dest.x), Math.abs(source.y - dest.y));
        Cell[] steps = new Cell[size];
        int deltaX = Integer.compare(dest.x, source.x);
        int deltaY = Integer.compare(dest.y, source.y);
        int x = source.x;
        int y = source.y;
        for (int index = 0; index != size; index++) {
            x += deltaX;
            y += deltaY;
            steps[index] = super.findCell(x, y);
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookWhite(dest);
    }
}