import java.awt.*;

public class Algorithm {
    private final int BOX = 10;

    private int getRealCoordinate(int x) {
        return BOX * x + BOX;
    }

    public void ddaToDo(Graphics g, int x1, int y1, int x2, int y2) {
//        long start = System.currentTimeMillis();
//        for (int j = 1; j < 10000; j++) {
            float length = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
            float deltaX = (x2 - x1) / length;
            float deltaY = (y2 - y1) / length;
            float x = (float) x1;
            float y = (float) y1;
            float i = (float) 1.0;
            while (i <= length) {
                g.fillRect(getRealCoordinate((int) x), getRealCoordinate((int) y), BOX, BOX);
                x += deltaX;
                y += deltaY;
                i = i + 1;
            }
//        }
//        long duration = System.currentTimeMillis() - start;
//        System.out.println("DDA " + duration);
    }


    public void brezenLineToDo(Graphics g, int x1, int y1, int x2, int y2) {
//        long start = System.currentTimeMillis();
//        for (int j = 1; j < 10000; j++) {
            int x, y, dx, dy, incx, incy, pdx, pdy, es, el, err;

            dx = x2 - x1;
            dy = y2 - y1;

            incx = Integer.compare(dx, 0);
            incy = Integer.compare(dy, 0);

            dx = Math.abs(dx);
            dy = Math.abs(dy);

            if (dx > dy) {
                pdx = incx;
                pdy = 0;
                es = dy;
                el = dx;
            } else {
                pdx = 0;
                pdy = incy;
                es = dx;
                el = dy;
            }

            x = x1;
            y = y1;
            err = el / 2;
            g.fillRect(getRealCoordinate(x), getRealCoordinate(y), BOX, BOX);

            for (int t = 0; t < el; t++) {
                err -= es;
                if (err < 0) {
                    err += el;
                    x += incx;
                    y += incy;
                } else {
                    x += pdx;
                    y += pdy;
                }

                g.fillRect(getRealCoordinate(x), getRealCoordinate(y), BOX, BOX);
            }

//        }
//        long duration = System.currentTimeMillis() - start;
//        System.out.println("brezenLine " + duration);
    }

    public void brezenCircleToDo(Graphics g, int x1, int y1, int r) {
        int x = 0;
        int y = r;
        int F = 0;
        int delta = 2 - 2 * r;
        while (y >= 0) {
            g.fillRect(getRealCoordinate(x1 + x), getRealCoordinate(y1 + y), BOX, BOX);
            g.fillRect(getRealCoordinate(x1 - x), getRealCoordinate(y1 + y), BOX, BOX);
            g.fillRect(getRealCoordinate(x1 + x), getRealCoordinate(y1 - y), BOX, BOX);
            g.fillRect(getRealCoordinate(x1 - x), getRealCoordinate(y1 - y), BOX, BOX);
            F = 2 * (delta + y) - 1;
            if ((delta < 0) && (F <= 0)) {
                x += 1;
                delta += 2 * x + 1;
                continue;
            }
            if ((delta > 0) && (F > 0)) {
                y -= 1;
                delta -= 2 * y + 1;
                continue;
            }
            x += 1;
            y -= 1;
            delta += 2 * (x - y);
        }
    }

    public void vuToDo(Graphics g, int x1, int y1, int x2, int y2) {
        if (x2 < x1) {
            x1 += x2;
            x2 = x1 - x2;
            x1 -= x2;
            y1 += y2;
            y2 = y1 - y2;
            y1 -= y2;
        }
        int dx = x2 - x1;
        int dy = y2 - y1;

        float gradient = 0;
        if (dx > dy) {
            gradient = (float) dy / dx;
            float intery = y1 + gradient;
            g.setColor(Color.BLACK);
            g.drawLine(x1, y1, x1, y1);
            for (int x = x1; x < x2; ++x) {
                g.setColor(new Color(0, 0, 0, (int) (255 - fractionalPart(intery) * 255))); //Меняем прозрачность
                g.fillRect(getRealCoordinate(x), getRealCoordinate((int) intery), BOX, BOX);
                g.setColor(new Color(0, 0, 0, (int) (fractionalPart(intery) * 255)));
                g.fillRect(getRealCoordinate(x), getRealCoordinate((int) intery + 1), BOX, BOX);
                intery += gradient;
            }
            g.setColor(Color.BLACK);
            g.fillRect(getRealCoordinate(x2), getRealCoordinate(y2), BOX, BOX);
        } else {
            gradient = (float) dx / dy;
            float interx = x1 + gradient;
            g.setColor(Color.BLACK);
            g.drawLine(x1, y1, x1, y1);
            for (int y = y1; y < y2; ++y) {
                g.setColor(new Color(0, 0, 0, (int) (255 - fractionalPart(interx) * 255)));
                g.fillRect(getRealCoordinate((int) interx), getRealCoordinate(y), BOX, BOX);
                g.setColor(new Color(0, 0, 0, (int) (fractionalPart(interx) * 255)));
                g.fillRect(getRealCoordinate((int) interx + 1), getRealCoordinate(y), BOX, BOX);
                interx += gradient;
            }
            g.setColor(Color.BLACK);
            g.fillRect(getRealCoordinate(x2), getRealCoordinate(y2), BOX, BOX);
        }


    }

    private float fractionalPart(float x) {
        int tmp = (int) x;
        return x - tmp; //вернёт дробную часть числа
    }


}
