import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BoardTest {

    private Board board;

    @Before
    public void setUp() {

        board = new Board(3, 3);
    }

    @Test
    public void testBoardIsInitialized() {

        board.initializeBoard();
        board.printBoard();
        checkCellsArePopulated(board);
    }

    @Test
    public void testSetCellValue() {

        board.initializeBoard();
        System.out.println("Before setting cell value");
        board.printBoard();
        int cellValue = board.getCellValue(1, 1);
        System.out.println("After setting cell value");
        if(cellValue == 1) {
            board.setCellValue(1, 1, 0);
        }
        else {
            board.setCellValue(1,1,1);
        }
          board.printBoard();
    }
    private void checkCellsArePopulated(Board board) {

        for (int i = 0; i < board.getRowLength(); i++) {
            for (int j = 0; j < board.getColLength(); j++) {
                if (board.getCellValue(i, j) == 0 || board.getCellValue(i, j) == 1) {
                    assertTrue(true);
                } else {
                    assertTrue(false);
                }
            }
        }
    }
}
