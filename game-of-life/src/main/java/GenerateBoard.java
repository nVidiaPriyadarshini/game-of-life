
public class GenerateBoard {

    private static Board board;

    public static Board getBlockBoard() {

        board = new Board(4, 4);
        board.initializeBoard();
        return initializeBlockBoard(board);
    }

    public static Board getBlinkerBoard() {
        board = new Board(5, 5);
        return initializeBlinkerBoard(board);
    }

    private static Board initializeBlockBoard(Board board) {

        for (int j = 0; j < 4; j++) {
            board.setCellValue(0, j, 0);
            board.setCellValue(3, 0, 0);
        }
        for (int i = 0; i < 4; i++) {
            board.setCellValue(i, 0, 0);
            board.setCellValue(i, 3, 0);
        }
        board.setCellValue(1, 1, 1);
        board.setCellValue(1, 2, 1);
        board.setCellValue(2, 1, 1);
        board.setCellValue(2, 2, 1);
        return board;
    }

    private static Board initializeBlinkerBoard(Board board) {


        board.setCellValue(1, 2, 1);
        board.setCellValue(2, 2, 1);
        board.setCellValue(3, 2, 1);
        return board;
    }
}
