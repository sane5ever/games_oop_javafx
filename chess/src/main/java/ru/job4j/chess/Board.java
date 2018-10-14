package ru.job4j.chess;

import ru.job4j.chess.exeptions.*;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Board {
    /** хранилище фигур */
    private final Figure[] figures = new Figure[32];
    /** указатель на первую свободную ячейку в массиве с фигурами */
    private int index = 0;

    /**
     * добавление шахматной фигуры на поле
     * @param figure фигура
     */
    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    /**
     * обеспечивает ход в игре
     * @param source клетка, с кот. осуществляется ход
     * @param dest клетка, на кот. осуществляется ход
     * @return true, если ход удался
     * @throws ImpossibleMoveException ход противоречит правилам движения фигуры
     * @throws OccupiedWayException препятствие на пути фигуры
     * @throws FigureNotFoundException в клетка, с кот. осуществляется ход, нет фигуры
     */
    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        int index = this.findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException("no figure in here!");
        }
        Cell[] steps = this.figures[index].way(source, dest);
        if (this.isNotEmpty(steps)) {
            throw new OccupiedWayException("path isn't empty");
        }
        this.figures[index] = this.figures[index].copy(dest);
        return true;
    }

    /**
     * очистищает массив с фигурами (используется при сбросе игры)
     */
    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    /**
     * ищет фигуру в хранилище с заданной клеткой
     * @param cell клетка доски
     * @return номер ячейки в массиве фигур, при её отсутствии -1
     */
    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    /**
     * проверяет, явл. ли заданная последовательность клеток незанятой фигурами из хранилища
     * @param steps массив клеток
     * @return true, если все клетки свободны
     */
    private boolean isNotEmpty(Cell[] steps) {
        boolean result = false;
        for (Cell step : steps) {
            if (this.findBy(step) != -1) {
                result = true;
                break;
            }
        }
        return result;
    }
}
