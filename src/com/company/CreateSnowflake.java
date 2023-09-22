package com.company;

import java.awt.*;

public class CreateSnowflake {

    public static void drawLine(int x0, int y0, int x1, int y1, int numAlgorithm, Graphics g) {
        AlgorithmsOfLine l = new AlgorithmsOfLine();

        if (numAlgorithm == 0) {
            l.ddaAlgorithm(x0, y0, x1, y1, g);            // DDA
        } else if (numAlgorithm == 1) {
            l.bresanheimAlgorithm(x0, y0, x1, y1, g);     // Bresenham
        } else {
            l.byAlgorithm(x0, y0, x1, y1, g);             // By
        }
    }

    public static void createSnowflake(int dX, int dY, int numAlgorithm, Graphics g) {

        drawLine(200 + dX, 100 + dY, 200 + dX, 300 + dY, 0, g);
        drawLine(100 + dX, 200 + dY, 300 + dX, 200 + dY, 0, g);
        drawLine(150 + dX, 200 + dY,200 + dX, 150 + dY, numAlgorithm, g);
        drawLine(200 + dX, 150 + dY, 250 + dX, 200 + dY, numAlgorithm, g);
        drawLine(150 + dX, 200 + dY,  200 + dX, 250 + dY, numAlgorithm, g);
        drawLine(200 + dX, 250 + dY, 250 + dX, 200 + dY, numAlgorithm, g);


        drawLine(180 + dX, 100 + dY, 200 + dX, 120 + dY, numAlgorithm, g);
        drawLine(200 + dX, 120 + dY, 220 + dX, 100 + dY, numAlgorithm, g);

        drawLine(280 + dX, 200 + dY, 300 + dX, 180 + dY, numAlgorithm, g);
        drawLine(280 + dX, 200 + dY, 300 + dX, 220 + dY, numAlgorithm, g);

        drawLine(180 + dX, 300 + dY, 200 + dX, 280 + dY, numAlgorithm, g);
        drawLine(200 + dX, 280 + dY, 220 + dX, 300 + dY, numAlgorithm, g);

        drawLine(100 + dX, 180 + dY, 120 + dX, 200 + dY, numAlgorithm, g);
        drawLine(100 + dX, 220 + dY, 120 + dX, 200 + dY, numAlgorithm, g);

    }

}
