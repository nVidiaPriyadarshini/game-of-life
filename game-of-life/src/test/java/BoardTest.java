import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
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
        if (cellValue == 1) {
            board.setCellValue(1, 1, 0);
            assertTrue("Set cell value failed", board.getCellValue(1, 1) == 0);
        } else {
            board.setCellValue(1, 1, 1);
            assertTrue("Set cell value failed", board.getCellValue(1, 1) == 1);

        }
        board.printBoard();
    }

    @Test
    public void testBlockBoardIsGenerated() {

        Board board = GenerateBoard.getBlockBoard();
        board.printBoard();
        assertEquals(board.isCellAlive(1, 1), true);
        assertEquals(board.isCellAlive(1, 2), true);
        assertEquals(board.isCellAlive(2, 1), true);
        assertEquals(board.isCellAlive(2, 2), true);

        for (int j = 0; j < 4; j++) {

            assertEquals(board.isCellAlive(0, j), false);
            assertEquals(board.isCellAlive(3, j), false);
        }

        for (int i = 0; i < 4; i++) {

            assertEquals(board.isCellAlive(i, 0), false);
            assertEquals(board.isCellAlive(i, 3), false);
        }

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
