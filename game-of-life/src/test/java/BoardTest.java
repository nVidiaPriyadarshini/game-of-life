import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BoardTest {

    private Board board;
    private static final String HEAT_CHART_TITLE = "test-Heat-Chart.png";

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
    public void testRandomFourCrossFourBoardIsGenerated() {

        board = GenerateBoard.getRandomizedFourCrossFourBoard();
        assertNotNull(board.getCellValue(0, 0));
        Cell[][] cells = board.getCells();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++)
                System.out.println("\t" + cells[i][j]);
        }
        board.printBoard();
    }

    @Test
    public void testBlockBoardIsGenerated() {

        Board board = GenerateBoard.getBlockBoard();
        System.out.println("Block Board");
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

    @Test
    public void testBlinkerBoardIsGenerated() {

        Board board = GenerateBoard.getBlinkerBoard();
        System.out.println("Blinker Board");
        board.printBoard();
        assertEquals(board.isCellAlive(1, 2), true);
        assertEquals(board.isCellAlive(2, 2), true);
        assertEquals(board.isCellAlive(3, 2), true);

    }

    @Test
    public void testGetLiveNeighborsCountForBlinkerBoardSeed() {
        Board board = GenerateBoard.getBlinkerBoard();
        System.out.println("Blinker Board");
        board.printBoard();

        //first row
        assertEquals(0, board.getLiveNeighborsCount(0, 0));
        assertEquals(1, board.getLiveNeighborsCount(0, 1));
        assertEquals(1, board.getLiveNeighborsCount(0, 2));
        assertEquals(1, board.getLiveNeighborsCount(0, 3));
        assertEquals(0, board.getLiveNeighborsCount(0, 4));
        //second row
        assertEquals(0, board.getLiveNeighborsCount(1, 0));
        assertEquals(2, board.getLiveNeighborsCount(1, 1));
        assertEquals(1, board.getLiveNeighborsCount(1, 2));
        assertEquals(2, board.getLiveNeighborsCount(1, 3));
        assertEquals(0, board.getLiveNeighborsCount(1, 4));
        //third row
        assertEquals(0, board.getLiveNeighborsCount(2, 0));
        assertEquals(3, board.getLiveNeighborsCount(2, 1));
        assertEquals(2, board.getLiveNeighborsCount(2, 2));
        assertEquals(3, board.getLiveNeighborsCount(2, 3));
        assertEquals(0, board.getLiveNeighborsCount(0, 4));
        //fourth row
        assertEquals(0, board.getLiveNeighborsCount(3, 0));
        assertEquals(2, board.getLiveNeighborsCount(3, 1));
        assertEquals(1, board.getLiveNeighborsCount(3, 2));
        assertEquals(2, board.getLiveNeighborsCount(3, 3));
        assertEquals(0, board.getLiveNeighborsCount(3, 4));
        //fifth row
        assertEquals(0, board.getLiveNeighborsCount(4, 0));
        assertEquals(1, board.getLiveNeighborsCount(4, 1));
        assertEquals(1, board.getLiveNeighborsCount(4, 2));
        assertEquals(1, board.getLiveNeighborsCount(4, 3));
        assertEquals(0, board.getLiveNeighborsCount(4, 4));

    }

    @Test
    public void testStateChangeForBlinkerBoardSeed() {

        Board board = GenerateBoard.getBlinkerBoard();
        System.out.println("Blinker Board");
        board.printBoard();
        Board nextStateOfBoard = LifeCycle.getNextStateOfBoard(board);
        nextStateOfBoard.printBoard();
        Board nextStateOfBoard1 = LifeCycle.getNextStateOfBoard(nextStateOfBoard);
        nextStateOfBoard1.printBoard();
        Board lastStateChangeTest = LifeCycle.getNextStateOfBoard(nextStateOfBoard1);
        lastStateChangeTest.printBoard();
        Board nextStateOfBoard2 = LifeCycle.getNextStateOfBoard(lastStateChangeTest);
        nextStateOfBoard2.printBoard();
    }

    @Ignore
    @Test
    public void testHeatChartIsGenerated() throws IOException {
        Board board = GenerateBoard.getBlinkerBoard();
        // board.constructHeatMap(HEAT_CHART_TITLE);
        File file = new File(HEAT_CHART_TITLE);
        assertTrue(file.exists());
        assertTrue(!file.isDirectory());
        assertTrue(file.delete());
    }

    @Test
    public void testGetLiveNeighborsCountForBlockBoardSeed() {
        Board board = GenerateBoard.getBlockBoard();
        board.printBoard();

        assertEquals(3, board.getLiveNeighborsCount(1, 1));
        assertEquals(3, board.getLiveNeighborsCount(1, 2));
        assertEquals(3, board.getLiveNeighborsCount(2, 1));
        assertEquals(3, board.getLiveNeighborsCount(2, 2));
        assertEquals(1, board.getLiveNeighborsCount(0, 0));
        assertEquals(2, board.getLiveNeighborsCount(0, 1));
        assertEquals(2, board.getLiveNeighborsCount(0, 2));
        assertEquals(1, board.getLiveNeighborsCount(0, 3));
        assertEquals(2, board.getLiveNeighborsCount(1, 0));
        assertEquals(2, board.getLiveNeighborsCount(1, 3));
        assertEquals(2, board.getLiveNeighborsCount(2, 0));
        assertEquals(2, board.getLiveNeighborsCount(2, 3));
        assertEquals(1, board.getLiveNeighborsCount(3, 0));
        assertEquals(2, board.getLiveNeighborsCount(3, 1));
        assertEquals(2, board.getLiveNeighborsCount(3, 2));
        assertEquals(1, board.getLiveNeighborsCount(3, 3));


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
