import java.util.Random;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.Polygon;
import java.lang.*;

public class CollatzGrapher extends Canvas {
    public void paint (Graphics g) {

        Random r = new Random();
        long num = 12342, maxNum = 0;
        int iterations = 0;
        int x = 80;
        int y = 800;
        int root;

        g.setFont(new Font ("Arial", Font.PLAIN, 20));
        g.setColor(Color.GRAY);
        g.drawString("Number: " + num, 700, 100);
        while (num != 1) {
            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            if (num % 2 == 1) {
                iterations++;
                x += 3;
                num = num * 3 + 1;
                if (num > maxNum) {
                    maxNum = num;
                }
                root = (int) Math.floor(Math.sqrt(num));
                g.drawLine(x, y, x, y - root);
            } else {
                iterations++;
                x += 3;
                num = num / 2;
                if (num > maxNum) {
                    maxNum = num;
                }
                root = (int) Math.floor(Math.sqrt(num));
                g.drawLine(x, y, x, y - root);
            }
        }
        g.setColor(Color.GRAY);
        g.drawString("Iterations: " + iterations, 700, 120);
        g.drawString("Max number: " + maxNum, 700, 140);
    }

    public static void main (String[] args) {
        JFrame win = new JFrame("Collatz Grapher");
        win.setSize(1024, 900);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CollatzGrapher canvas = new CollatzGrapher();
        canvas.setBackground(Color.BLACK);
        win.add(canvas);
        win.setVisible(true);
    }
}
