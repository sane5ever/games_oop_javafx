package ru.job4j.chess.exeptions;

/**
 * Ход не соответствует правилам игры.
 */
public class ImpossibleMoveException extends RuntimeException {

    public ImpossibleMoveException(String message) {
        super(message);
    }
}
