
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    enum BoardType {
        BLOCK, BEEHIVE, LOAF, BOAT, TUB, BLINKER, TOAD, BEACON, PULSAR, GLIDER, LWSS, RANDOM
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose from following seed board types :");
        System.out.println("BLOCK,BEEHIVE,LOAF,BOAT,TUB,BLINKER,TOAD,BEACON,PULSAR,GLIDER,LWSS, RANDOM ");
        BoardType boardType = BoardType.valueOf(reader.readLine());
        System.out.println("Enter number of iterations");
        int iterations = Integer.parseInt(reader.readLine());
        Board board = null;
        switch (boardType) {

            case BLOCK:
                board = GenerateBoard.getBlockBoard();
                break;
            case BEEHIVE:
                board = GenerateBoard.getBeehiveBoard();
                break;
            case LOAF:
                board = GenerateBoard.getLoafBoard();
                break;
            case BOAT:
                board = GenerateBoard.getBoatBoard();
                break;
            case TUB:
                board = GenerateBoard.getTubBoard();
                break;
            case BLINKER:
                board = GenerateBoard.getBlinkerBoard();
                break;
            case TOAD:
                board = GenerateBoard.getToadBoard();
                break;
            case BEACON:
                board = GenerateBoard.getBeaconBoard();
                break;
            case PULSAR:
                board = GenerateBoard.getPulsarBoard();
                break;
            case GLIDER:
                board = GenerateBoard.getGliderBoard();
                break;
            case LWSS:
                board = GenerateBoard.getLeightWeightSpaceShip();
                break;
            case RANDOM:
                board = GenerateBoard.getRandomizedFourCrossFourBoard();
                break;
            default:
                System.out.println("Valid pattern type was not entered");
                break;

        }

        if (board != null) {
            Board nextStateOfBoard;
            for (int i = 0; i < iterations; i++) {
                nextStateOfBoard = LifeCycle.getNextStateOfBoard(board);
                nextStateOfBoard.printBoard();
                board = nextStateOfBoard.clone();
            }
        }
    }
}
