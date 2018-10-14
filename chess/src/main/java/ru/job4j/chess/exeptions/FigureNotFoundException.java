package ru.job4j.chess.exeptions;

/**
 * Фигура не найдена.
 */
public class FigureNotFoundException extends RuntimeException {

    public FigureNotFoundException(String message) {
        super(message);
    }
}
