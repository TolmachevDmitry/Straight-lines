package com.company;

import javax.swing.*;
import java.awt.*;

public class CreatePicture extends JFrame {

    CreatePicture() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);

        CreateSnowflake sn = new CreateSnowflake();
        sn.createSnowflake(0, 0, 0, g);
        sn.createSnowflake(400, 0, 1, g);
        sn.createSnowflake(800, 0, 2, g);

    }
}
