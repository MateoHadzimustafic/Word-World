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

public class StartUpPage {

    public static void main(String[] args) {

        // adding a starting frame on startup of game
        JFrame startingFrame = new JFrame();
        startingFrame.setSize(1000, 900);
        startingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startingFrame.setVisible(true);
        startingFrame.getContentPane().setLayout(new CardLayout());

        // setting up the start up panel
        JPanel startingPanel = new JPanel();
        startingFrame.getContentPane().add(startingPanel);
        startingPanel.setBackground(new Color(0, 128, 0));
        startingPanel.setLayout(null);

        // welcoming label
        JLabel startingLabel = new JLabel("Trivia Night");
        startingLabel.setFont(new Font("Serif", Font.PLAIN, 70));
        startingLabel.setBounds(350, 150, 345, 90);
        startingPanel.add(startingLabel);

        JButton play = new JButton("Play");
        play.setFont(new Font("Serif", Font.BOLD, 20));
        play.setBackground(new Color(0, 150, 0));
        play.setBounds(250, 375, 150, 75);
        play.setBorder(BorderFactory.createLineBorder(Color.black));
        startingPanel.add(play);

        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GamePage game = new GamePage();
                game.page();
                startingFrame.setVisible(false);
            }
        });

        JButton rules = new JButton("Rules");
        rules.setFont(new Font("Serif", Font.BOLD, 20));
        rules.setBounds(450, 375, 150, 75);
        rules.setBackground(new Color(0, 150, 0));
        rules.setBorder(BorderFactory.createLineBorder(Color.black));
        startingPanel.add(rules);

        rules.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RulesPage rule = new RulesPage();
                rule.page();
                startingFrame.setVisible(false);
            }
        });

        JButton scores = new JButton("Scores");
        scores.setFont(new Font("Serif", Font.BOLD, 20));
        scores.setBounds(650, 375, 150, 75);
        scores.setBackground(new Color(0, 150, 0));
        scores.setBorder(BorderFactory.createLineBorder(Color.black));
        startingPanel.add(scores);

        scores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ScoresPage score = new ScoresPage();
                score.page();
                startingFrame.setVisible(false);
            }
        });

    }
}