package org.iesfm.ticTacToe;

import org.iesfm.ticTacToe.exceptions.InvalidPositionException;
import org.iesfm.ticTacToe.exceptions.NotYourTurnException;
import org.iesfm.ticTacToe.exceptions.PositionInUseException;

public interface ITicTacToe {
    void putX(int x, int y) throws InvalidPositionException, PositionInUseException, NotYourTurnException;
    void putO(int x, int y) throws InvalidPositionException, PositionInUseException, NotYourTurnException;

    Character[][] getBoard();

    void setBoard(Character[][] board);

    void reset();

    boolean isFinished();

    String getWinner();

    String getTurn();
}
