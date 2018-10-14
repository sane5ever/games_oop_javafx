package ru.job4j.chess.firuges;

import ru.job4j.chess.exeptions.ImpossibleMoveException;

public abstract class Figure {
    private final Cell position;

    public Figure(Cell position) {
        this.position = position;
    }

    public Cell position() {
        return this.position;
    }

    /**
     * формирует последовательность клеток, чз кот. проходит фигура при движении
     *
     * @param source клетка, из кот. осуществляется движение
     * @param dest   клетка, в кот. осуществляется движение
     * @return массив клеток при движении
     * @throws ImpossibleMoveException ход противеоречит правилам движения текущей фигуры
     */
    public abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    /**
     * создание фигуры с заданным расположением
     *
     * @param dest клетка создаваемой фигуры
     * @return фигура-наследник текущего класса
     */
    public abstract Figure copy(Cell dest);

    public String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    /**
     * поиск клетки по её координатам
     *
     * @param x х-координата
     * @param y y-координата
     * @return клетка доски
     */
    public Cell findCell(int x, int y) {
        Cell result = null;
        for (Cell cell : Cell.values()) {
            if (cell.x == x && cell.y == y) {
                result = cell;
                break;
            }
        }
        return result;
    }
}