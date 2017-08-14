
public class Main {
    public static void main(String[] args) {


        Board board = GenerateBoard.getBlinkerBoard();
        board.printBoard();
        Board nextStateOfBoard;
        for (int count = 0; count < 10; count++) {
            nextStateOfBoard = LifeCycle.getNextStateOfBoard(board);
            nextStateOfBoard.printBoard();
            board = nextStateOfBoard.clone();
        }
    }
}
