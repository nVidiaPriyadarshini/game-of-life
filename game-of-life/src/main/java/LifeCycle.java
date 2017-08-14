public class LifeCycle {

    public static Board getNextStateOfBoard(Board board) {

        Board nextStateOfBoard = board.clone();

        Boolean nextStateOfCell;

        for (int m = 0; m < board.getRowLength(); m++) {
            for (int n = 0; n < board.getColLength(); n++) {
                nextStateOfCell = getNextStateOfCell(board, m, n);
                if (nextStateOfCell) {
                    nextStateOfBoard.setCellValue(m, n, 1);
                } else {
                    nextStateOfBoard.setCellValue(m, n, 0);
                }
            }
        }
        return nextStateOfBoard;
    }

    private static Boolean getNextStateOfCell(Board board, int rowPosition, int colPosition) {

        Cell cell = board.getCell(rowPosition, colPosition);

        int liveNeighborsCount = board.getLiveNeighborsCount(rowPosition, colPosition);

        return determineNextStateOfCellBasedOnGameRules(liveNeighborsCount, cell);

    }

    private static Boolean determineNextStateOfCellBasedOnGameRules(int liveNeighborsCount, Cell cell) {

        Boolean isCellAlive = (Boolean) cell.getCellState();

        if (!isCellAlive) {
            return liveNeighborsCount == 3;
        } else {
            if (liveNeighborsCount < 2) {
                return false;
            } else if (liveNeighborsCount == 2 || liveNeighborsCount == 3) {
                return true;
            }
            return false;

        }
    }
}
