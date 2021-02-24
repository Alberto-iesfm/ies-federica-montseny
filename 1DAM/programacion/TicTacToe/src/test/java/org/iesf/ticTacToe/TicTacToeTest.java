package org.iesf.ticTacToe;

import org.iesfm.ticTacToe.TicTacToe;
import org.iesfm.ticTacToe.exceptions.InvalidPositionException;
import org.iesfm.ticTacToe.exceptions.NotYourTurnException;
import org.iesfm.ticTacToe.exceptions.PositionInUseException;
import org.junit.Assert;
import org.junit.Test;

public class TicTacToeTest {

    private TicTacToe game = new TicTacToe();

    @Test
    public void noMoreMovesTest(){
        Character[][] board = {
                {'X', 'X', 'O'},
                {'O', 'O', 'X'},
                {'X', 'O', 'X'}
        };
        game.setBoard(board);

        boolean finished = game.isFinished();
        String winner = game.getWinner();

        Assert.assertTrue(finished);
        Assert.assertEquals("Draw", winner);
    }

    @Test (expected = InvalidPositionException.class)
    public void invalidPositionTest () throws InvalidPositionException, NotYourTurnException, PositionInUseException{
        Character[][] board = {
                {null, null, null},
                {null, null, null},
                {null, null, null}
        };
                game.setBoard(board);

                game.putX(3, 4);
    }
}
// tablero TicTacToe
// for (int i = 0; i < board.length; i++) {
//    if(i == 0) {
//        System.out.println("|̄ ̄ ̄ |̄ ̄ ̄ |̄ ̄ ̄ |");
//    } else{
//        System.out.println("|   |   |   |");
//    }
//    Character[] row = board[i];
//    for (int j = 0; j < row.length; j++) {
//        if (row[j] == null) {
//            System.out.print("|   ");
//        } else if (row[j] == 'X') {
//            System.out.print("| X ");
//        } else {
//            System.out.print("| O ");
//        }
//    }
//    System.out.println("|");
//    System.out.println("|___|___|___|");
//}