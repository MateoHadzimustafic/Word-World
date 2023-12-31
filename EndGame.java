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

public class EndGame {

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

        JFrame startingFrame = new JFrame();
        startingFrame.setSize(1000, 900);
        startingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startingFrame.setVisible(true);
        startingFrame.getContentPane().setLayout(new CardLayout());

        JPanel startingPanel = new JPanel();
        startingFrame.getContentPane().add(startingPanel);
        startingPanel.setBackground(new Color(0, 128, 0));
        startingPanel.setLayout(null);

        JLabel endingLabel2 = new JLabel("Here is your score", SwingConstants.CENTER);
        endingLabel2.setBounds(250, 250, 500, 60);
        endingLabel2.setFont(new Font("Serif", Font.PLAIN, 40));
        startingPanel.add(endingLabel2);

        JButton back = new JButton("Back to main menu");
        back.setFont(new Font("Serif", Font.BOLD, 25));
        back.setBounds(385, 465, 250, 50);
        back.setBackground(new Color(0, 150, 0));
        startingPanel.add(back);

        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                StartUpPage start = new StartUpPage();

                start.main(null);
                startingFrame.setVisible(false);
            }

        });

        if (scores.size() == 1 && names.size() == 1) {

            JLabel endingLabel4 = new JLabel("Name: " + names.get(0), SwingConstants.CENTER);
            endingLabel4.setBounds(25, 350, 300, 60);
            endingLabel4.setFont(new Font("Serif", Font.PLAIN, 40));
            startingPanel.add(endingLabel4);

            JLabel endingLabel3 = new JLabel(scores.get(0), SwingConstants.CENTER);
            endingLabel3.setBounds(300, 350, 700, 60);
            endingLabel3.setFont(new Font("Serif", Font.PLAIN, 40));
            startingPanel.add(endingLabel3);
        } else {

            JLabel endingLabel3 = new JLabel(scores.get(scores.size() - 1), SwingConstants.CENTER);
            endingLabel3.setBounds(300, 350, 700, 60);
            endingLabel3.setFont(new Font("Serif", Font.PLAIN, 40));
            startingPanel.add(endingLabel3);

            JLabel endingLabel4 = new JLabel("Name: " + names.get(scores.size() - 1), SwingConstants.CENTER);
            endingLabel4.setBounds(25, 350, 300, 60);
            endingLabel4.setFont(new Font("Serif", Font.PLAIN, 40));
            startingPanel.add(endingLabel4);

        }

    }
}
