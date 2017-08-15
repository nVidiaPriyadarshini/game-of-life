import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.SerializationUtils;
import org.tc33.jheatchart.HeatChart;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board implements Serializable {

    private double[][] board;

    private int rowLength, colLength;

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public Board(int rowLength, int colLength) {
        this.rowLength = rowLength;
        this.colLength = colLength;
        this.board = new double[rowLength][colLength];
    }

    @Override
    public Board clone() {
        Board copyOfBoard = SerializationUtils.clone(this);
        return copyOfBoard;
    }

    /*
     Set the initial state of the board to all 0
     */
    public double[][] initializeBoard() {
        for (int i = 0; i < this.rowLength; i++) {
            for (int j = 0; j < this.colLength; j++) {
                this.board[i][j] = 0;
            }
        }
        return this.board;
    }

    public void constructHeatMap(String fileName) throws IOException {
        HeatChart heatChart = new HeatChart(this.board);
        heatChart.setTitle("Game of Life");
        heatChart.setHighValueColour(Color.green);
        heatChart.setLowValueColour(Color.red);
        heatChart.setShowXAxisValues(false);
        heatChart.setShowYAxisValues(false);
        heatChart.saveToFile(new File(fileName));

    }

    /*
     Print the contents of the board
     */
    public void printBoard() {

        System.out.println("----Printing board----");
        for (int i = 0; i < this.rowLength; i++) {
            for (int j = 0; j < this.colLength; j++) {
                String formattedValue = new DecimalFormat("#").format(this.board[i][j]);
                if (this.board[i][j] == 0) {
                    System.out.print("\t" + ANSI_RED + formattedValue + ANSI_RESET);
                } else if (this.board[i][j] == 1) {
                    System.out.print("\t" + ANSI_GREEN + formattedValue + ANSI_RESET);

                }
            }
            System.out.println("");
        }
        System.out.println("-----End of board-----");

        System.out.println("**********************");
    }

    /*
     Generate a random cell value in the board
     */
    private int getRandomCellValue() {
        boolean value = Math.random() < 0.5;
        return (value) ? 1 : 0;
    }

    public double getCellValue(int rowPosition, int colPosition) {

        return this.board[rowPosition][colPosition];
    }

    public void setCellValue(int rowPosition, int colPosition, int value) {

        this.board[rowPosition][colPosition] = value;
    }

    public boolean isCellAlive(int rowPosition, int colPosition) {

        double cellValue = -1;
        if (rowPosition >= 0 && rowPosition < this.getRowLength() && colPosition >= 0 && colPosition < this.getColLength()) {


            cellValue = this.getCellValue(rowPosition, colPosition);
        }
        return cellValue != 0;
    }

    public int getLiveNeighborsCount(int rowPosition, int colPosition) {

        int liveNeighbourCnt = 0;
        List<Cell<Integer, Integer, Boolean>> neighbors = getNeighbors(rowPosition, colPosition);
        for (Cell neighbourCell : neighbors) {
            if (((Integer) neighbourCell.getRowPosition() >= 0)
                    && ((Integer) neighbourCell.getRowPosition() < this.getRowLength())
                    && ((Integer) neighbourCell.getColPosition() >= 0)
                    && ((Integer) neighbourCell.getColPosition() < this.getColLength())) {
                if ((boolean) neighbourCell.getCellState()) {
                    liveNeighbourCnt++;
                }
            }
        }
        return liveNeighbourCnt;
    }

    public Cell<Integer, Integer, Boolean> getCell(int rowPosition, int colPosition) {

        return new Cell<>(rowPosition, colPosition, this.isCellAlive(rowPosition, colPosition));

    }

    private List<Cell<Integer, Integer, Boolean>> getNeighbors(int rowPosition, int colPosition) {

        List<Cell<Integer, Integer, Boolean>> neighbourCells = new ArrayList<>();

        Cell neighbourCell = new Cell(rowPosition - 1, colPosition - 1
                , this.isCellAlive(rowPosition - 1, colPosition - 1));
        neighbourCells.add(neighbourCell);
        neighbourCell = new Cell(rowPosition - 1, colPosition
                , this.isCellAlive(rowPosition - 1, colPosition));
        neighbourCells.add(neighbourCell);
        neighbourCell = new Cell(rowPosition - 1, colPosition + 1
                , this.isCellAlive(rowPosition - 1, colPosition + 1));
        neighbourCells.add(neighbourCell);
        neighbourCell = new Cell(rowPosition, colPosition - 1
                , this.isCellAlive(rowPosition, colPosition - 1));
        neighbourCells.add(neighbourCell);
        neighbourCell = new Cell(rowPosition + 1, colPosition - 1
                , this.isCellAlive(rowPosition + 1, colPosition - 1));
        neighbourCells.add(neighbourCell);
        neighbourCell = new Cell(rowPosition + 1, colPosition
                , this.isCellAlive(rowPosition + 1, colPosition));
        neighbourCells.add(neighbourCell);
        neighbourCell = new Cell(rowPosition + 1, colPosition + 1
                , this.isCellAlive(rowPosition + 1, colPosition + 1));
        neighbourCells.add(neighbourCell);
        neighbourCell = new Cell(rowPosition, colPosition + 1
                , this.isCellAlive(rowPosition, colPosition + 1));
        neighbourCells.add(neighbourCell);

        return neighbourCells;
    }
}
