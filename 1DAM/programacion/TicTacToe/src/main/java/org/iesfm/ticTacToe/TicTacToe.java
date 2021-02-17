package org.iesfm.ticTacToe;

import org.iesfm.ticTacToe.exceptions.InvalidPositionException;
import org.iesfm.ticTacToe.exceptions.NotYourTurnException;
import org.iesfm.ticTacToe.exceptions.PositionInUseException;

public class TicTacToe implements ITicTacToe{

    public TicTacToe() {
    }

    @Override
    public void putX(int x, int y) throws InvalidPositionException, PositionInUseException, NotYourTurnException {

    }

    @Override
    public void putO(int x, int y) throws InvalidPositionException, PositionInUseException, NotYourTurnException {

    }

    @Override
    public Character[][] getBoard() {
        return new Character[0][];
    }

    @Override
    public void setBoard(Character[][] board) {

    }

    @Override
    public void reset() {

    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public String getWinner() {
        return null;
    }

    @Override
    public String getTurn() {
        return null;
    }
}
