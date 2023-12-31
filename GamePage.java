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
import javax.swing.*;

public class GamePage {

    public void page() {

        JFrame gameFrame = new JFrame();
        gameFrame.setSize(1000, 900);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
        gameFrame.getContentPane().setLayout(new CardLayout());

        JPanel gamePanel = new JPanel();
        gameFrame.getContentPane().add(gamePanel);
        gamePanel.setBackground(new Color(0, 128, 0));
        gamePanel.setLayout(null);

        JLabel categories = new JLabel("Categories");
        categories.setFont(new Font("Serif", Font.PLAIN, 70));
        categories.setBounds(380, 100, 350, 100);
        gamePanel.add(categories);

        JLabel nameTag = new JLabel("Name:");
        nameTag.setFont(new Font("Serif", Font.PLAIN, 15));
        nameTag.setBounds(435, 210, 100, 50);
        gamePanel.add(nameTag);

        JTextField name = new JTextField();
        name.setBounds(500, 225, 100, 25);
        name.setBackground(new Color(0, 150, 0));
        gamePanel.add(name);

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

        JButton sports = new JButton("Sports");
        sports.setBounds(250, 300, 150, 75);
        sports.setFont(new Font("Serif", Font.BOLD, 15));
        sports.setBackground(new Color(0, 150, 0));
        sports.setBorder(BorderFactory.createLineBorder(Color.black));
        gamePanel.add(sports);

        sports.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (name.getText().isEmpty()) {

                    name.setText("Unknown");
                }

                BufferedWriter bw;

                try {
                    bw = new BufferedWriter(new FileWriter("Name.txt", true));
                    bw.write(name.getText().toString());
                    bw.newLine();
                    bw.close();
                } catch (IOException e1) {

                    e1.printStackTrace();
                }

                Sports sport = new Sports();
                sport.page();
                gameFrame.setVisible(false);
            }
        });

        JButton famous = new JButton("Famous people");
        famous.setBounds(450, 300, 150, 75);
        famous.setFont(new Font("Serif", Font.BOLD, 15));
        famous.setBackground(new Color(0, 150, 0));
        famous.setBorder(BorderFactory.createLineBorder(Color.black));
        gamePanel.add(famous);

        famous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BufferedWriter bw;

                if (name.getText().isEmpty()) {

                    name.setText("Unknown");
                }

                try {
                    bw = new BufferedWriter(new FileWriter("Name.txt", true));
                    bw.write(name.getText().toString());
                    bw.newLine();
                    bw.close();
                } catch (IOException e1) {

                    e1.printStackTrace();
                }

                FamousPeople famous = new FamousPeople();
                famous.page();
                gameFrame.setVisible(false);
            }
        });

        JButton countries = new JButton("Countries");
        countries.setBounds(650, 300, 150, 75);
        countries.setFont(new Font("Serif", Font.BOLD, 15));
        countries.setBackground(new Color(0, 150, 0));
        countries.setBorder(BorderFactory.createLineBorder(Color.black));
        gamePanel.add(countries);

        countries.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BufferedWriter bw;

                if (name.getText().isEmpty()) {

                    name.setText("Unknown");
                }

                try {
                    bw = new BufferedWriter(new FileWriter("Name.txt", true));
                    bw.write(name.getText().toString());
                    bw.newLine();
                    bw.close();
                } catch (IOException e1) {

                    e1.printStackTrace();
                }

                Countries countires = new Countries();
                countires.page();
                gameFrame.setVisible(false);
            }
        });

        JButton moviesShows = new JButton("Movies/Shows");
        moviesShows.setBounds(250, 450, 150, 75);
        moviesShows.setFont(new Font("Serif", Font.BOLD, 15));
        moviesShows.setBackground(new Color(0, 150, 0));
        moviesShows.setBorder(BorderFactory.createLineBorder(Color.black));
        gamePanel.add(moviesShows);

        moviesShows.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BufferedWriter bw;

                if (name.getText().isEmpty()) {

                    name.setText("Unknown");
                }

                try {
                    bw = new BufferedWriter(new FileWriter("Name.txt", true));
                    bw.write(name.getText().toString());
                    bw.newLine();
                    bw.close();
                } catch (IOException e1) {

                    e1.printStackTrace();
                }

                MoviesShows movieShows = new MoviesShows();
                movieShows.page();
                gameFrame.setVisible(false);
            }
        });

        JButton history = new JButton("History");
        history.setBounds(450, 450, 150, 75);
        history.setFont(new Font("Serif", Font.BOLD, 15));
        history.setBackground(new Color(0, 150, 0));
        history.setBorder(BorderFactory.createLineBorder(Color.black));
        gamePanel.add(history);

        history.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BufferedWriter bw;

                if (name.getText().isEmpty()) {

                    name.setText("Unknown");
                }

                try {
                    bw = new BufferedWriter(new FileWriter("Name.txt", true));
                    bw.write(name.getText().toString());
                    bw.newLine();
                    bw.close();
                } catch (IOException e1) {

                    e1.printStackTrace();
                }

                History books = new History();
                books.page();
                gameFrame.setVisible(false);
            }
        });

        JButton randomFacts = new JButton("Random facts");
        randomFacts.setBounds(650, 450, 150, 75);
        randomFacts.setFont(new Font("Serif", Font.BOLD, 15));
        randomFacts.setBackground(new Color(0, 150, 0));
        randomFacts.setBorder(BorderFactory.createLineBorder(Color.black));
        gamePanel.add(randomFacts);

        randomFacts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BufferedWriter bw;

                if (name.getText().isEmpty()) {

                    name.setText("Unknown");
                }

                try {
                    bw = new BufferedWriter(new FileWriter("Name.txt", true));
                    bw.write(name.getText().toString());
                    bw.newLine();
                    bw.close();
                } catch (IOException e1) {

                    e1.printStackTrace();
                }

                RandomFacts random = new RandomFacts();
                random.page();
                gameFrame.setVisible(false);
            }
        });

    }

}
