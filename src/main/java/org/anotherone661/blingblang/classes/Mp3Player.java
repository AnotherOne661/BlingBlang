package org.anotherone661.blingblang.classes;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class Mp3Player {
    private final String filepath;
    private boolean loop;

    public Mp3Player(String filepath, boolean loop) {
        this.filepath = filepath;
        this.loop = loop;
    }

    public void play() {
        try (InputStream audioInputStream = getClass().getResourceAsStream(filepath)) {
            if (audioInputStream != null) {
                AudioInputStream ais = AudioSystem.getAudioInputStream(audioInputStream);
                Clip clip = AudioSystem.getClip();
                clip.open(ais);

                if (loop) {
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                }

                clip.start();
            } else {
                System.err.println("Audio file not found: " + filepath);
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
