import java.util.ArrayList;

public class Bezier {
    private Bezier() {
    }

    public static ArrayList<Point> bezierGoGo(ArrayList<Point> sourcePoints) {
        // ф-ия расчитывает финальный набор точек, по которым будет строится кривуля, а затем рисует ее
        ArrayList<Point> finalPoints = new ArrayList<Point>();

        for (double t = 0; t <= 1; t += 0.001)
            finalPoints.add(calculateBezierFunction(t, sourcePoints));
        return finalPoints;
    }

    private static Point calculateBezierFunction(double t, ArrayList<Point> srcPoints) {
        // ф-ия расчитывает очередную точку на кривой исходя из входного набора управляющих точек
        double x = 0;
        double y = 0;

        int n = srcPoints.size() - 1;
        for (int i = 0; i <= n; i++) {
            x += fact(n) / (fact(i) * fact(n - i)) * srcPoints.get(i).getX() * Math.pow(t, i) * Math.pow(1 - t, n - i);
            y += fact(n) / (fact(i) * fact(n - i)) * srcPoints.get(i).getY() * Math.pow(t, i) * Math.pow(1 - t, n - i);
        }
        return new Point((int) x, (int) y);
    }

    private static double fact(double arg) {
        if (arg < 0) throw new RuntimeException("negative argument.");
        if (arg == 0) return 1;

        double rezult = 1;
        for (int i = 1; i <= arg; i++)
            rezult *= i;
        return rezult;
    }

    public static ArrayList<Point> goToRight(ArrayList<Point> sourcePoints) {
        for (Point point : sourcePoints) {
            point.setX(point.getX() + 5);
        }
        return sourcePoints;
    }

    public static ArrayList<Point> goToLeft(ArrayList<Point> sourcePoints) {
        for (Point point : sourcePoints) {
            point.setX(point.getX() - 5);
        }
        return sourcePoints;
    }

    public static ArrayList<Point> goToUP(ArrayList<Point> sourcePoints) {
        for (Point point : sourcePoints) {
            point.setY(point.getY() - 5);
        }
        return sourcePoints;
    }

    public static ArrayList<Point> goToDown(ArrayList<Point> sourcePoints) {
        for (Point point : sourcePoints) {
            point.setY(point.getY() + 5);
        }
        return sourcePoints;
    }

    public static ArrayList<Point> scalePlus(ArrayList<Point> sourcePoints) {
        for (Point point : sourcePoints) {
            point.setX((int) (point.getX() * 1.1));
            point.setY((int) (point.getY() * 1.1));
        }
        return sourcePoints;
    }

    public static ArrayList<Point> scaleMinus(ArrayList<Point> sourcePoints) {
        for (Point point : sourcePoints) {
            point.setX((int) (point.getX() * 0.9));
            point.setY((int) (point.getY() * 0.9));
        }
        return sourcePoints;
    }

    public static ArrayList<Point> corn(ArrayList<Point> sourcePoints) {
        double corner = Math.toRadians(5.0);
        boolean first = true;
        for (Point point : sourcePoints) {
            point.setX((int) ((point.getX() * Math.cos(corner)) - (point.getY() * Math.sin(corner))));
            point.setY((int) ((point.getX() * Math.sin(corner)) + (point.getY() * Math.cos(corner))));
        }
        return sourcePoints;
    }

    public static ArrayList<Point> mirror(ArrayList<Point> sourcePoints) {
        int lastX = sourcePoints.get(sourcePoints.size() - 1).getX();
        for (Point point : sourcePoints) {
            point.setX((0 - point.getX()) + 2 * lastX);
        }
        return sourcePoints;
    }


}
