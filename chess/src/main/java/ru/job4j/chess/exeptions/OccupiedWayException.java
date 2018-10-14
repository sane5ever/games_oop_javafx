package ru.job4j.chess.exeptions;

/**
 * Движение невозможно из-за другой фигуры на пути.
 */
public class OccupiedWayException extends RuntimeException {

    public OccupiedWayException(String message) {
        super(message);
    }
}
