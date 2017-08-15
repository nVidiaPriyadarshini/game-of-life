
public class GenerateBoard {

    private static Board board;
    private static Cell[][] cells;

    public static Board getRandomizedFourCrossFourBoard() {
        board = new Board(4, 4);
        return initializeRandomBoard(board);
    }

    public static Board getBlockBoard() {

        board = new Board(4, 4);
        board.initializeBoard();
        return initializeBlockBoard(board);
    }

    /*
    Generate a random cell value in the board
    */
    private static int getRandomCellValue() {
        boolean value = Math.random() < 0.5;
        return (value) ? 1 : 0;
    }

    private static Board initializeRandomBoard(Board board) {

        int rowLength = board.getRowLength();
        int colLength = board.getColLength();
        cells = new Cell[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                int randomCellValue = getRandomCellValue();
                Cell cell = new Cell(i, j, randomCellValue);
                board.setCellValue(i, j, randomCellValue);
                cells[i][j] = cell;
            }
        }
        board.setCells(cells);
        return board;
    }

    public static Board getBlinkerBoard() {
        board = new Board(5, 5);
        board.initializeBoard();
        return initializeBlinkerBoard(board);
    }

    private static Board initializeBlockBoard(Board board) {
        int rowLength = board.getRowLength();
        int colLength = board.getColLength();
        cells = board.getCells();

        for (int j = 0; j < colLength; j++) {
            Cell cell = new Cell(0, j, 0);
            cells[0][j] = cell;
            cell = new Cell(3, 0, 0);
            cells[3][0] = cell;
        }
        for (int i = 0; i < rowLength; i++) {
            Cell cell = new Cell(i, 0, 0);
            cells[i][0] = cell;
            cell = new Cell(i, 3, 0);
            cells[i][3] = cell;
        }
        Cell cell = new Cell(1, 1, 1);
        cells[1][1] = cell;
        cell = new Cell(1, 2, 1);
        cells[1][2] = cell;
        cell = new Cell(2, 1, 1);
        cells[2][1] = cell;
        cell = new Cell(2, 2, 1);
        cells[2][2] = cell;
        board.setCells(cells);
        return board;
    }

    private static Board initializeBlinkerBoard(Board board) {
        cells = board.getCells();
        cells[1][2] = new Cell(1, 2, 1);
        cells[2][2] = new Cell(2, 2, 1);
        cells[3][2] = new Cell(3, 2, 1);
        board.setCells(cells);
        return board;
    }
}
