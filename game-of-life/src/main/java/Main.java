public class Main {

    public static void main(String[] args) {

        Board board = GenerateBoard.getRandomizedFourCrossFourBoard();
        Board nextStateOfBoard;
        for(int i = 0 ; i< 100 ; i++) {
            nextStateOfBoard = LifeCycle.getNextStateOfBoard(board);
            nextStateOfBoard.printBoard();
            board = nextStateOfBoard.clone();
        }
    }
}
