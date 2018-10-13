package ru.job4j.puzzle;

import ru.job4j.puzzle.firuges.Cell;
import ru.job4j.puzzle.firuges.Figure;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final int size;
    private final Figure[] figures;
    private int index = 0;

    public Logic(int size) {
        this.size = size;
        this.figures = new Figure[size * size];
    }

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            if (this.isFree(steps)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
        }
        return rst;
    }

    public boolean isFree(Cell ... cells) {
        boolean result = cells.length > 0;
        for (Cell cell : cells) {
            if (this.findBy(cell) != -1) {
               result = false;
               break;
            }
        }
        return result;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

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
     * проверяет ячейки всех горизонталей и вертикалей (до первой успешной) на наличие выигрышной комбинации
     * @return true, если выигрышная линия найдена
     */
    public boolean isWin() {
        int[][] table = this.convert();
        boolean result = false;
        for (int index = 0; index < this.size; index++) {
          if (this.checkTheLine(index, 0, 0, 1, table)
                || this.checkTheLine(0, index, 1, 0, table)) {
              result = true;
              break;
          }
        }
        return result;
    }
    /**
     * проверяет ячейки определённой параметрами линии (горизонталь/вертикаль) в матрице на передаваемое в параметрах условие
     * @param x номер столбца начальной ячейки матрицы
     * @param y номер строки начальной ячейки матрицы
     * @param dx приращение по столбцам при движении по проверяемой линии
     * @param dy приращение по строкам при движении по проверяемой линии
     * @param table матрица, в кот. осуществляется проверка
     * @return true, если заданное условие выполняется в каждой ячейке заданной линии матрицы
     */
    private boolean checkTheLine(int x, int y, int dx, int dy, int[][] table) {
        boolean result = true;
        for (int index = 0; index != this.size; index++) {
            if (table[x][y] != 1) {
                result = false;
                break;
            }
            x += dx;
            y += dy;
        }
        return result;
    }

    int[][] convert() {
        int[][] table = new int[this.size][this.size];
        for (int row = 0; row != table.length; row++) {
            for (int cell = 0; cell != table.length; cell++) {
                int position = this.findBy(new Cell(row, cell));
                if (position != -1 && this.figures[position].movable()) {
                    table[row][cell] = 1;
                }
            }
        }
        return table;
    }
}
