package ru.job4j.chess.firuges.white;

import ru.job4j.chess.exeptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopWhite extends Figure {
    public BishopWhite(Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (isNotDiagonal(source, dest)) {
            throw new ImpossibleMoveException("Bishop moves wrong!");
        }
        int size = Math.abs(source.x - dest.x);
        Cell[] steps = new Cell[size];
        int deltaX = source.x < dest.x ? 1 : -1;
        int deltaY = source.y < dest.y ? 1 : -1;
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
        return new BishopWhite(dest);
    }

    private boolean isNotDiagonal(Cell source, Cell dest) {
        return Math.abs(source.x - dest.x) != Math.abs(source.y - dest.y);
    }
}