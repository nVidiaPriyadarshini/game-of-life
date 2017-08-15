import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        Board board = GenerateBoard.getBlinkerBoard();
        board.printBoard();
        board.constructHeatMap("game-of-life-heat-chart.png");

        Board nextStateOfBoard = LifeCycle.getNextStateOfBoard(board);
        nextStateOfBoard.printBoard();
        nextStateOfBoard.constructHeatMap("game-of-life-heat-chart1.png");

    }


}
