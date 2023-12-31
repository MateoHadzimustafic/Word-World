import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.event.SwingPropertyChangeSupport;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.awt.CardLayout;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;;

public class ScoresPage {

    public void page() {

        ArrayList<String> scores = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        BufferedReader br;
        String line;

        try {
            br = new BufferedReader(new FileReader("Score.txt"));
            while ((line = br.readLine()) != null) {

                scores.add(line);

            }
        } catch (IOException err) {
            System.out.println("There was an issue");
        }

        try {
            br = new BufferedReader(new FileReader("Name.txt"));
            while ((line = br.readLine()) != null) {

                names.add(line);

            }
        } catch (IOException err) {
            System.out.println("There was an issue");

        }

        JFrame gameFrame = new JFrame();
        gameFrame.setSize(1000, 900);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
        gameFrame.getContentPane().setLayout(new CardLayout());

        JPanel gamePanel = new JPanel();
        gameFrame.getContentPane().add(gamePanel);
        gamePanel.setBackground(new Color(0, 128, 0));
        gamePanel.setLayout(null);

        JButton back = new JButton("Back");
        back.setFont(new Font("Serif", Font.BOLD, 15));
        back.setBounds(25, 820, 75, 25);
        back.setBackground(new Color(0, 150, 0));
        gamePanel.add(back);

        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                StartUpPage start = new StartUpPage();

                start.main(null);
                gameFrame.setVisible(false);
            }

        });

        int x = 25;
        int y = 15;

        if (scores.size() == 1) {

            JLabel result = new JLabel("Name: " + names.get(0) + " " + scores.get(0));
            result.setFont(new Font("Serif", Font.BOLD, 15));
            result.setBounds(x, y, 400, 50);
            gamePanel.add(result);

        } else if (scores.size() > 1) {

            for (int i = scores.size() - 1; i >= 0; i--) {

                JLabel result = new JLabel("Name: " + names.get(i) + " " + scores.get(i));
                result.setFont(new Font("Serif", Font.BOLD, 15));
                result.setBounds(x, y, 400, 50);
                gamePanel.add(result);

                y += 50;

                if (y >= 800) {
                    x += 500;
                    y = 15;
                }

            }

        }

    }

}
