package org.anotherone661.blingblang.ui;

import org.anotherone661.blingblang.Settings;

import javax.swing.*;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.anotherone661.blingblang.classes.Mp3Player;
import org.anotherone661.blingblang.classes.URL;


public class Window extends JFrame{

    private JPanel panel;
    private JLabel bgLabel;
    private ImageIcon bg;
    private Timer timer;
    private Mp3Player mp3Player;
    Window(){
        this(Settings.TITLE, Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT, Settings.WINDOW_RESIZABLE, Settings.ALWAYS_ON_TOP, Settings.ICON_PATH);
    }
    public Window(String title, int width, int height, boolean windowResizable, boolean alwaysOnTop, String iconPath) {
        setTitle(title);
        setSize(width, height);
        setPreferredSize(Settings.WINDOW_SIZE);
        setMinimumSize(Settings.WINDOW_SIZE);
        setMaximumSize(Settings.WINDOW_SIZE);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(windowResizable);
        setAlwaysOnTop(alwaysOnTop);
        init();
        setUpUI();
        pack();
        loadIcon(iconPath);
        setLocationRelativeTo(null);

        Mp3Player mp3Player = new Mp3Player("/blingblangaudio.wav", true);
        mp3Player.play();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowIconified(WindowEvent e) {
                Window.this.setState(JFrame.NORMAL);
            }
        }

        );

        startMoving();
    }

    private void init() {
        // Override this method to initialize the
        bg = new ImageIcon(Window.class.getResource(Settings.BG_PATH));
        bgLabel = new JLabel(bg);


        panel = new JPanel(new BorderLayout());
        panel.add(bgLabel, BorderLayout.CENTER);
        URL.openURL("https://youtu.be/qrJKQr_0jig");
    }

    private void setUpUI() {
        // Override this method to set up the UI
        add(panel);
    }

    private void loadIcon(String path) {
        Image icon = new ImageIcon(Window.class.getResource(path)).getImage();
        setIconImage(icon);
    }

    private void startMoving() {
        timer = new Timer(500, e -> {
            int x = (int) (Math.random() * (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()));
            int y = (int) (Math.random() * (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()));
            setLocation(x, y);
        });
        timer.start();
    }
}
