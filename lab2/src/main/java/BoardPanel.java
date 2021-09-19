import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class BoardPanel extends JComponent {
    private final static int maxPane = 6;
    public int pane = 1;
    ArrayList<Point> srcPoint = new ArrayList<Point>();
    ArrayList<Point> finalPoint = new ArrayList<Point>();
    private KeyAdapter kl = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            ArrayList<Point> temp = new ArrayList<Point>(srcPoint);
            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT:
                    srcPoint.clear();
                    srcPoint.addAll(Bezier.goToRight(temp));
                    finalPoint.clear();
                    finalPoint.addAll(Bezier.bezierGoGo(srcPoint));
                    temp.clear();
                    repaint();
                    break;
                case KeyEvent.VK_LEFT:
                    srcPoint.clear();
                    srcPoint.addAll(Bezier.goToLeft(temp));
                    finalPoint.clear();
                    finalPoint.addAll(Bezier.bezierGoGo(srcPoint));
                    temp.clear();
                    repaint();
                    break;
                case KeyEvent.VK_UP:
                    srcPoint.clear();
                    srcPoint.addAll(Bezier.goToUP(temp));
                    finalPoint.clear();
                    finalPoint.addAll(Bezier.bezierGoGo(srcPoint));
                    temp.clear();
                    repaint();
                    break;
                case KeyEvent.VK_DOWN:
                    srcPoint.clear();
                    srcPoint.addAll(Bezier.goToDown(temp));
                    finalPoint.clear();
                    finalPoint.addAll(Bezier.bezierGoGo(srcPoint));
                    temp.clear();
                    repaint();
                    break;
                case KeyEvent.VK_9:
                    srcPoint.clear();
                    srcPoint.addAll(Bezier.scalePlus(temp));
                    finalPoint.clear();
                    finalPoint.addAll(Bezier.bezierGoGo(srcPoint));
                    temp.clear();
                    repaint();
                    break;
                case KeyEvent.VK_0:
                    srcPoint.clear();
                    srcPoint.addAll(Bezier.scaleMinus(temp));
                    finalPoint.clear();
                    finalPoint.addAll(Bezier.bezierGoGo(srcPoint));
                    temp.clear();
                    repaint();
                    break;
                case KeyEvent.VK_U:
                    srcPoint.clear();
                    srcPoint.addAll(Bezier.corn(temp));
                    finalPoint.clear();
                    finalPoint.addAll(Bezier.bezierGoGo(srcPoint));
                    temp.clear();
                    repaint();
                    break;
                case KeyEvent.VK_M:
                    srcPoint.clear();
                    srcPoint.addAll(Bezier.mirror(temp));
                    finalPoint.clear();
                    finalPoint.addAll(Bezier.bezierGoGo(srcPoint));
                    temp.clear();
                    repaint();
                    break;
                default:
                    break;

            }
        }
    };

    private MouseAdapter ml = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (pane <= maxPane) {
                Point point = new Point(e.getX(), e.getY());
                System.out.println(point.getX() + "  " + point.getY() + " pane " + pane);
                srcPoint.add(point);
                getGraphics().fillOval(point.getX(), point.getY(), 4, 4);
                if (pane == maxPane) finalPoint.addAll(Bezier.bezierGoGo(srcPoint));
                pane++;

            } else {
                repaint();
            }

        }
    };

    public BoardPanel() {

        setFocusable(true);
        addKeyListener(kl);
        addMouseListener(ml);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        drawCurve(finalPoint, g);
        //drawPane(g);
    }

    public void drawCurve(ArrayList<Point> points, Graphics g) {
        for (int i = 1; i < points.size(); i++) {
            int x1 = points.get(i - 1).getX();
            int y1 = points.get(i - 1).getY();
            int x2 = points.get(i).getX();
            int y2 = points.get(i).getY();
            ddaToDo(g, x1, y1, x2, y2);
        }
    }

    public void drawPane(Graphics g){
        for (Point point : srcPoint) {
            g.fillOval(point.getX(), point.getY(), 4, 4);
        }

    }

    public void ddaToDo(Graphics g, int x1, int y1, int x2, int y2) {
        float length = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
        float deltaX = (x2 - x1) / length;
        float deltaY = (y2 - y1) / length;
        float x = (float) x1;
        float y = (float) y1;
        float i = (float) 1.0;
        while (i <= length) {
            g.fillRect((int) x, (int) y, 1, 1);
            x += deltaX;
            y += deltaY;
            i = i + 1;
        }
    }

}


