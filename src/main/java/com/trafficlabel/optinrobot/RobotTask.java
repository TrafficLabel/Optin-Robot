package com.trafficlabel.optinrobot;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Noy @ TrafficLabel 2018
 */
final class RobotTask implements Optin {

    private static String[] loadSites() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("sites.txt"))) {
            return reader.lines().map(String::trim).filter(line -> line.length() > 0).toArray(String[]::new);
        }
    }

    @Override
    public void work() {
        try {
            Robot robot = new Robot();
            for (String sites : loadSites()) {
                if (sites.length() == 0) { quit(); }
                robot.mouseMove(1500,300);
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
                robot.delay(800);
                robot.mouseMove(1200,400);
                robot.delay(800);
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);

                StringSelection stringSelection = new StringSelection(sites);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);

                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.delay(200);
                robot.keyPress(KeyEvent.VK_V);
                robot.delay(200);
                robot.keyRelease(KeyEvent.VK_V);
                robot.delay(200);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.delay(200);

                robot.mouseMove(1200,460);
                robot.delay(500);
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);

                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.delay(200);
                robot.keyPress(KeyEvent.VK_V);
                robot.delay(200);
                robot.keyRelease(KeyEvent.VK_V);
                robot.delay(200);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.delay(200);

                robot.mouseMove(520,520);
                robot.delay(500);
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
                System.out.printf("[%s] Created: %s.\n", new SimpleDateFormat("hh:mm:ss a").format(new Date()), sites);
                robot.delay(3500); // Allowing time for the page to load back.
            }
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void quit() {
        System.out.println("We out!");
        System.exit(0);
    }
}
