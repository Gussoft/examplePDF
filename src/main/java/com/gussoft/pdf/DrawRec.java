package com.gussoft.pdf;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class DrawRec extends JFrame {
    public DrawRec() {
        super("Rectangles Drawing Demo");

        getContentPane().setBackground(Color.WHITE);
        setSize(480, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    void drawRectangles(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        double x = 29.5d;
        double y = 48.8d;
        double width = 413.2d;
        double height = 118.6d;

        Rectangle2D.Double rect = new Rectangle2D.Double(x, y, width, height);
        g2d.draw(rect);
        // code to draw rectangles goes here...

    }

    public void paint(Graphics g) {
        super.paint(g);
        drawRectangles(g);
    }

    public static void main(String[] args) throws Exception {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DrawRec().setVisible(true);
            }
        });
    }
}
