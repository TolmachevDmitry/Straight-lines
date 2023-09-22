package com.company;

import javax.swing.*;
import java.awt.*;

public class AlgorithmsOfLine  extends JPanel {

    private void plot(int x, int y, Graphics g) {

        Graphics2D gr = (Graphics2D) g;
        gr.fillRect(x, y, 1, 1);

    }


    // For By
    private void plot1(int x, int y, double c, Graphics g) {

        Color shine;
        if (c < 0.3) {
            shine = Color.BLACK;
        } else if (c > 0.3 && c < 0.7) {
            shine = Color.darkGray;
        } else {
            shine = Color.gray;
        }

        Graphics2D gr = (Graphics2D) g;
        gr.setColor(shine);
        gr.fillRect(x, y, 1, 1);

    }

    // Bresenham's Algorithm
    public void bresanheimAlgorithm(int x0, int y0, int x1, int y1, Graphics g) {

        int dX = Math.abs(x1 - x0);
        int dY = Math.abs(y1 - y0);

        int error = 0;
        int dError = dY + 1;

        int y = y0;
        int diry = y1 - y0;

        if (diry > 0) {
            diry = 1;
        }
        if (diry < 0) {
            diry = -1;
        }

        for (int x = x0; x < x1; x++) {

            plot(x, y, g);
            error = error + dError;

            if (error >= dX + 1) {
                y = y + diry;
                error = error - (dX + 1);
            }

        }

    }


    // Algorithm DDA
    public void ddaAlgorithm(int x0, int y0, int x1, int y1, Graphics g) {

        double l = Math.max(Math.abs(x1 - x0), Math.abs(y1 - y0));

        double dX = (x1 - x0) / l;
        double dY = (y1 - y0) / l;

        double [] arrayX = new double[2000];
        double [] arrayY = new double[2000];

        double x = x0;
        double y = y0;
        for (int i = 0; i < l; i++) {
            arrayX[i] = x;
            arrayY[i] = y;

            x += dX;
            y += dY;
        }

        for (int i = 0; i < l; i++) {
            plot((int)arrayX[i], (int)arrayY[i], g);
        }

    }


    private double fPart(double x) {
        return x - (int)x;
    }

    // By's Algorithm
    public void byAlgorithm(int x0, int y0, int x1, int y1, Graphics g) {

        if (x1 < x0) {
            int t = x1;
            x1 = x0;
            x0 = t;

            t = y1;
            y1 = y0;
            y0 = t;
        }

        double dX = x1 - x0;
        double dY = y1 - y0;
        double gradient = dY / dX;

        double xEnd = x0;
        double yEnd = y0 + gradient * (xEnd - x0);
        double xGap = 1 - fPart(x0 + 0.5);
        double xPxl1 = xEnd;

        double yPxl1 = (int)yEnd;
        plot1((int)xPxl1, (int)yPxl1, (1 - yEnd) * xGap, g);
        plot1((int)xPxl1, (int)(yPxl1 + 1), yEnd * xGap, g);
        double intery = yEnd + gradient;

        xEnd = x1;
        yEnd = y1 + gradient * (xEnd - x1);
        xGap = fPart(x1 + 0.5);
        double xPxl2 = xEnd;

        double yPxl2 = (int)yEnd;
        plot1((int)xPxl2, (int)yPxl2, (1 - yEnd) * xGap, g);
        plot1((int)xPxl2, (int)(yPxl2 + 1), yEnd * xGap, g);

        for (double x = xPxl1; x < xPxl2; x++) {
            plot1((int)x, (int)intery, 1 - fPart(intery), g);
            plot1((int)x, (int)intery + 1, fPart(intery), g);

            intery += gradient;
        }

    }

}
