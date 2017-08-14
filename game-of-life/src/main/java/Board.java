import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {

    private int[][] board;

    @Getter
    @Setter
    private int rowLength, colLength;


    public Board(int rowLength, int colLength) {
        this.rowLength = rowLength;
        this.colLength = colLength;
        this.board = new int[rowLength][colLength];
    }

    /*
     Set the initial state of the board
     */
    public int[][] initializeBoard() {
        for (int i = 0; i < this.rowLength; i++) {
            for (int j = 0; j < this.colLength; j++) {
                this.board[i][j] = getRandomCellValue();
            }
        }
        return this.board;
    }

    /*
     Print the contents of the board
     */
    public void printBoard() {

        for (int i = 0; i < this.rowLength; i++) {
            for (int j = 0; j < this.colLength; j++) {
                System.out.print("\t" + this.board[i][j]);
            }
            System.out.println("");
        }
    }

    /*
     Generate a random cell value in the board
     */
    private int getRandomCellValue() {
        boolean value = Math.random() < 0.5;
        return (value) ? 1 : 0;
    }

    public int getCellValue(int rowPosition, int colPosition) {

        return this.board[rowPosition][colPosition];
    }

    public void setCellValue(int rowPosition, int colPosition,int value) {

        this.board[rowPosition][colPosition] = value;
    }
}
