
public class Main {

    public static void main(String[] args) {


        Board board = GenerateBoard.getBlockBoard();
        board.printBoard();
        Board newBoard = board.clone();
        newBoard.printBoard();
        newBoard.setCellValue(0, 0, 1);
        board.printBoard();
        newBoard.printBoard();

    }
}
