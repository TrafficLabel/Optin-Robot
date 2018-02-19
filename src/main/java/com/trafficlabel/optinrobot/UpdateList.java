package com.trafficlabel.optinrobot;

import java.awt.*;
import java.awt.event.KeyEvent;

public class UpdateList implements Optin {

    @Override
    public void work() {
        try {
            for (int x = 0; x <= 200; x++) {
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
                Thread.sleep(200);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            }

        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void quit() {
        System.exit(0);
    }
}
