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

public class RulesPage {

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

        BufferedReader br;
        String line;
        int y = 200;

        try {
            br = new BufferedReader(new FileReader("Rules.txt"));

            while ((line = br.readLine()) != null) {

                JLabel rules = new JLabel(line);
                rules.setFont(new Font("Serif", Font.PLAIN, 15));
                rules.setBounds(170, y, 900, 50);
                gamePanel.add(rules);

                y += 50;

            }
        } catch (IOException err) {
            System.out.println("There was an issue");
        }

    }
}
