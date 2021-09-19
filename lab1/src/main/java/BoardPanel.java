import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    private final int BOX = 10;
    private Board board;

    public BoardPanel(Board board) {
        this.board = board;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard()[i].length; j++) {
                g.drawRect(BOX * i + BOX, BOX * j + BOX, BOX, BOX);
            }

        }
        //189 , 99
        Algorithm algorithm = new Algorithm();
        algorithm.vuToDo(g, 10, 60, 90, 10);
        //algorithm.brezenLineToDo(g, 20, 60, 100, 10);
        //algorithm.ddaToDo(g, 30, 60, 110, 10);

        //algorithm.brezenCircleToDo(g, 80, 45, 40);
        //bikerei(g);
        //g.fillRect(10,10,10,10);
    }

    private void bikerei(Graphics g){
        Algorithm bike = new Algorithm();
        bike.vuToDo(g, 5, 10, 5, 50);
        bike.vuToDo(g, 5, 10, 17, 10);
        bike.vuToDo(g, 17, 10, 20, 14);
        bike.vuToDo(g, 20, 14, 20, 27);
        bike.vuToDo(g, 20, 27, 17, 30);
        bike.vuToDo(g, 17, 30, 5, 30);
        bike.vuToDo(g, 17, 30, 20, 33);
        bike.vuToDo(g, 20, 33, 20, 47);
        bike.vuToDo(g, 20, 48, 17, 50);
        bike.vuToDo(g, 17, 50, 5, 50); // B

        bike.vuToDo(g, 24,  30, 24, 50);
        bike.brezenCircleToDo(g, 24, 25, 2); //i

        bike.vuToDo(g, 28, 10, 28, 50);
        bike.vuToDo(g, 35, 25, 28, 40);
        bike.vuToDo(g, 28, 40, 35, 50);//k

        bike.vuToDo(g, 40, 40, 55, 40);
        bike.vuToDo(g, 55, 40, 50, 35);
        bike.vuToDo(g, 40, 40, 45, 35);
        bike.vuToDo(g, 50, 35, 45, 35);
        bike.vuToDo(g, 40, 40, 40, 43);
        bike.vuToDo(g, 40, 43, 43, 50);
        bike.vuToDo(g, 43, 50, 47, 50);
        bike.vuToDo(g, 47, 50, 52, 50);
        bike.vuToDo(g, 52, 50, 55, 48);//e

        bike.vuToDo(g, 60, 30, 60, 50);
        bike.vuToDo(g, 60, 35, 63, 33);
        bike.vuToDo(g, 63, 33, 68, 33);
        bike.vuToDo(g, 68, 33, 70, 35); //r

        bike.vuToDo(g, 40 + 35, 40, 55 + 35, 40);
        bike.vuToDo(g, 55 + 35, 40, 50 + 35, 35);
        bike.vuToDo(g, 40 + 35, 40, 45 + 35, 35);
        bike.vuToDo(g, 50 + 35, 35, 45 + 35, 35);
        bike.vuToDo(g, 40 + 35, 40, 40 + 35, 43);
        bike.vuToDo(g, 40 + 35, 43, 43 + 35, 50);
        bike.vuToDo(g, 43 + 35, 50, 47 + 35, 50);
        bike.vuToDo(g, 47 + 35, 50, 52 + 35, 50);
        bike.vuToDo(g, 52 + 35, 50, 55 + 35, 48);//e

        bike.vuToDo(g, 95,  30, 95, 50);
        bike.brezenCircleToDo(g, 95, 25, 2); //i















    }


}
