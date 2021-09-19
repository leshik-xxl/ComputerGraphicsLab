import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        int width = 1920;
        int height = 1080;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(new BoardPanel());
        frame.setSize(width, height);
        frame.setVisible(true);
    }
}
