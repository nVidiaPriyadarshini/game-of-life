
public class GenerateBoard {

    private static Board board;
    private static Cell[][] cells;

    public static Board getRandomizedFourCrossFourBoard() {
        board = new Board(4, 4);
        return initializeRandomBoard(board);
    }

    public static Board getBeehiveBoard() {
        board = new Board(5, 6);
        board.initializeBoard();
        return initializeBeehiveBoard(board);

    }

    public static Board getLoafBoard() {
        board = new Board(6, 6);
        board.initializeBoard();
        return initializeLoafBoard(board);
    }

    public static Board getBoatBoard() {
        board = new Board(5, 5);
        board.initializeBoard();
        return initializeBoatBoard(board);
    }

    public static Board getTubBoard() {
        board = new Board(5, 5);
        board.initializeBoard();
        return initializeTubBoard(board);
    }

    private static Board initializeTubBoard(Board board) {
        board.setCellValue(1, 2, 1);
        board.setCellValue(2, 1, 1);
        board.setCellValue(2, 3, 1);
        board.setCellValue(3, 2, 1);

        return board;
    }

    private static Board initializeBoatBoard(Board board) {
        board.setCellValue(1, 1, 1);
        board.setCellValue(1, 2, 1);
        board.setCellValue(2, 1, 1);
        board.setCellValue(2, 3, 1);
        board.setCellValue(3, 2, 1);

        return board;
    }

    private static Board initializeLoafBoard(Board board) {
        board.setCellValue(1, 2, 1);
        board.setCellValue(1, 3, 1);
        board.setCellValue(2, 1, 1);
        board.setCellValue(2, 4, 1);
        board.setCellValue(3, 2, 1);
        board.setCellValue(3, 4, 1);
        board.setCellValue(4, 3, 1);

        return board;
    }

    private static Board initializeBeehiveBoard(Board board) {
        board.setCellValue(1, 2, 1);
        board.setCellValue(1, 3, 1);
        board.setCellValue(2, 1, 1);
        board.setCellValue(2, 4, 1);
        board.setCellValue(3, 2, 1);
        board.setCellValue(3, 3, 1);

        return board;
    }

    public static Board getGliderBoard() {
        board = new Board(6, 6);
        board.initializeBoard();
        return initializeGliderBoard(board);
    }

    public static Board getLeightWeightSpaceShip() {
        board = new Board(7, 7);
        board.initializeBoard();
        return initializeLeightWeightSpaceShipBoard(board);
    }

    public static Board getToadBoard() {
        board = new Board(6, 6);
        board.initializeBoard();
        return initializeToadBoard(board);
    }

    public static Board getPulsarBoard() {
        board = new Board(15, 15);
        board.initializeBoard();
        return initializePulsarBoard(board);
    }

    private static Board initializePulsarBoard(Board board) {
        board.setCellValue(1, 3, 1);
        board.setCellValue(1, 4, 1);
        board.setCellValue(1, 5, 1);
        board.setCellValue(1, 9, 1);
        board.setCellValue(1, 10, 1);
        board.setCellValue(1, 11, 1);
        board.setCellValue(3, 1, 1);
        board.setCellValue(3, 6, 1);
        board.setCellValue(3, 8, 1);
        board.setCellValue(3, 13, 1);
        board.setCellValue(4, 1, 1);
        board.setCellValue(4, 6, 1);
        board.setCellValue(4, 8, 1);
        board.setCellValue(4, 13, 1);
        board.setCellValue(5, 1, 1);
        board.setCellValue(5, 6, 1);
        board.setCellValue(5, 8, 1);
        board.setCellValue(5, 13, 1);
        board.setCellValue(6, 3, 1);
        board.setCellValue(6, 4, 1);
        board.setCellValue(6, 5, 1);
        board.setCellValue(6, 9, 1);
        board.setCellValue(6, 10, 1);
        board.setCellValue(6, 11, 1);
        board.setCellValue(8, 3, 1);
        board.setCellValue(8, 4, 1);
        board.setCellValue(8, 5, 1);
        board.setCellValue(8, 9, 1);
        board.setCellValue(8, 10, 1);
        board.setCellValue(8, 11, 1);
        board.setCellValue(9, 1, 1);
        board.setCellValue(9, 6, 1);
        board.setCellValue(9, 8, 1);
        board.setCellValue(9, 13, 1);
        board.setCellValue(10, 1, 1);
        board.setCellValue(10, 6, 1);
        board.setCellValue(10, 8, 1);
        board.setCellValue(10, 13, 1);
        board.setCellValue(11, 1, 1);
        board.setCellValue(11, 6, 1);
        board.setCellValue(11, 8, 1);
        board.setCellValue(11, 13, 1);
        board.setCellValue(13, 3, 1);
        board.setCellValue(13, 4, 1);
        board.setCellValue(13, 5, 1);
        board.setCellValue(13, 9, 1);
        board.setCellValue(13, 10, 1);
        board.setCellValue(13, 11, 1);

        return board;
    }

    private static Board initializeToadBoard(Board board) {
        board.setCellValue(1, 2, 1);
        board.setCellValue(1, 3, 1);
        board.setCellValue(1, 4, 1);
        board.setCellValue(2, 1, 1);
        board.setCellValue(2, 2, 1);
        board.setCellValue(2, 3, 1);
        return board;
    }

    public static Board getBeaconBoard() {
        board = new Board(6, 6);
        board.initializeBoard();
        return initializeBeaconBoard(board);
    }

    private static Board initializeBeaconBoard(Board board) {
        board.setCellValue(1, 1, 1);
        board.setCellValue(1, 2, 1);
        board.setCellValue(2, 1, 1);
        board.setCellValue(3, 4, 1);
        board.setCellValue(4, 3, 1);
        board.setCellValue(4, 4, 1);

        return board;
    }


    private static Board initializeLeightWeightSpaceShipBoard(Board board) {
        board.setCellValue(1, 2, 1);
        board.setCellValue(1, 5, 1);
        board.setCellValue(2, 1, 1);
        board.setCellValue(3, 1, 1);
        board.setCellValue(4, 1, 1);
        board.setCellValue(4, 2, 1);
        board.setCellValue(4, 3, 1);
        board.setCellValue(4, 4, 1);
        board.setCellValue(3, 5, 1);

        return board;
    }

    private static Board initializeGliderBoard(Board board) {
        board.setCellValue(2, 1, 1);
        board.setCellValue(1, 3, 1);
        board.setCellValue(2, 3, 1);
        board.setCellValue(3, 2, 1);
        board.setCellValue(3, 3, 1);
        return board;
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
