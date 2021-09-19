public class Board {
    private Point[][] board;

    public Board(int length, int width) {
        board = new Point[length][width];
    }

    public Point[][] getBoard() {
        return board;
    }
}

