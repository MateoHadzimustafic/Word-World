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

public class FamousPeople {

    private static Image heart, heart2, heart3, heart4, heart5, heart6;
    private static JLabel heartLogo, heartLogo2, heartLogo3, heartLogo4, heartLogo5, heartLogo6;
    int questionAcc = 1;
    int randomAcc = 0;
    ArrayList<Integer> list = new ArrayList<>();
    EndGame end = new EndGame();

    public void page() {

        HashMap<Integer, String> Questions = new HashMap<Integer, String>();
        HashMap<Integer, String> Answers = new HashMap<Integer, String>();

        BufferedReader br;
        String lineQuestion;
        String lineAnswer;
        int accQ = 0;
        int accA = 0;
        try {
            br = new BufferedReader(new FileReader("FamousPeopleQuestions.txt"));
            while ((lineQuestion = br.readLine()) != null) {
                Questions.put(accQ, lineQuestion);
                accQ++;
            }
        } catch (IOException err) {
            System.out.println("There was an issue");
        }

        try {
            br = new BufferedReader(new FileReader("FamousPeopleAnswers.txt"));
            while ((lineAnswer = br.readLine()) != null) {
                Answers.put(accA, lineAnswer);
                accA++;
            }
        } catch (IOException err) {
            System.out.println("There was an issue");
        }

        Scores score = new Scores("Famous People", 0, Questions.size());

        ArrayList numberList = randomNumber(list, Questions);

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

        try {

            heart = ImageIO.read(new File("Images/heart.png"));
            heart.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            heartLogo = new JLabel(new ImageIcon(heart));
            heartLogo.setBounds(680, 450, 200, 200);
            heartLogo.setVisible(true);
            startingPanel.add(heartLogo);

        } catch (IOException err) {

            System.out.println("Problem reading the file");
        }

        try {

            heart2 = ImageIO.read(new File("Images/heart.png"));
            heart2.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            heartLogo2 = new JLabel(new ImageIcon(heart2));
            heartLogo2.setBounds(580, 450, 200, 200);
            heartLogo2.setVisible(true);
            startingPanel.add(heartLogo2);

        } catch (IOException err) {

            System.out.println("Problem reading the file");
        }

        try {

            heart3 = ImageIO.read(new File("Images/heart.png"));
            heart3.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
            heartLogo3 = new JLabel(new ImageIcon(heart3));
            heartLogo3.setBounds(480, 450, 200, 200);
            heartLogo3.setVisible(true);
            startingPanel.add(heartLogo3);

        } catch (IOException err) {

            System.out.println("Problem reading the file");
        }

        try {

            heart4 = ImageIO.read(new File("Images/heart.png"));
            heart4.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
            heartLogo4 = new JLabel(new ImageIcon(heart4));
            heartLogo4.setBounds(380, 450, 200, 200);
            heartLogo4.setVisible(true);
            startingPanel.add(heartLogo4);

        } catch (IOException err) {

            System.out.println("Problem reading the file");
        }

        try {

            heart5 = ImageIO.read(new File("Images/heart.png"));
            heart5.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
            heartLogo5 = new JLabel(new ImageIcon(heart5));
            heartLogo5.setBounds(280, 450, 200, 200);
            heartLogo5.setVisible(true);
            startingPanel.add(heartLogo5);

        } catch (IOException err) {

            System.out.println("Problem reading the file");
        }

        try {

            heart6 = ImageIO.read(new File("Images/heart.png"));
            heart6.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
            heartLogo6 = new JLabel(new ImageIcon(heart6));
            heartLogo6.setBounds(180, 450, 200, 200);
            heartLogo6.setVisible(true);
            startingPanel.add(heartLogo6);

        } catch (IOException err) {

            System.out.println("Problem reading the file");
        }

        JLabel question = new JLabel(Questions.get((int) numberList.get(randomAcc)), SwingConstants.CENTER);
        question.setFont(new Font("Serif", Font.PLAIN, 15));
        question.setBounds(50, 200, 900, 50);
        startingPanel.add(question);

        JTextField ans = new JTextField();
        ans.setBounds(425, 300, 150, 25);
        startingPanel.add(ans);

        JLabel right = new JLabel("", SwingConstants.CENTER);
        right.setFont(new Font("Serif", Font.PLAIN, 20));
        right.setBounds(400, 325, 200, 50);
        startingPanel.add(right);

        JLabel currScore = new JLabel(String.valueOf(score.getScore()));
        currScore.setFont(new Font("Serif", Font.BOLD, 25));
        currScore.setBounds(925, 15, 50, 50);
        startingPanel.add(currScore);

        JLabel check = new JLabel("", SwingConstants.CENTER);
        check.setFont(new Font("Serif", Font.BOLD, 20));
        check.setBounds(450, 450, 100, 25);
        startingPanel.add(check);

        JButton submit = new JButton("Submit");
        submit.setBounds(425, 400, 150, 35);
        submit.setFont(new Font("Serif", Font.BOLD, 15));
        submit.setBackground(new Color(0, 150, 0));
        startingPanel.add(submit);

        submit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (ans.getText().trim().equalsIgnoreCase(Answers.get(numberList.get(randomAcc)))) {

                    right.setText("");
                    System.out.println("right");
                    score.inceaseScore();
                    check.setText("Correct");

                    if (Questions.size() == questionAcc) {

                        BufferedWriter bw;

                        try {
                            bw = new BufferedWriter(new FileWriter("Score.txt", true));
                            bw.write(score.toString());
                            bw.newLine();
                            bw.close();
                        } catch (IOException e1) {

                            e1.printStackTrace();
                        }
                        end.page();
                        startingFrame.setVisible(false);

                    } else {

                        randomAcc++;
                        question.setText(change(question, Questions, (int) numberList.get(randomAcc)));
                        questionAcc++;
                        ans.setText("");

                    }

                } else {

                    System.out.println("Wrong answer");
                    right.setText(Answers.get(numberList.get(randomAcc)));
                    check.setText("Incorrect");

                    if (heartLogo6.isVisible()) {
                        heartLogo6.setVisible(false);
                    } else if (heartLogo5.isVisible()) {
                        heartLogo5.setVisible(false);
                    } else if (heartLogo4.isVisible()) {
                        heartLogo4.setVisible(false);
                    } else if (heartLogo3.isVisible()) {
                        heartLogo3.setVisible(false);
                    } else if (heartLogo2.isVisible()) {
                        heartLogo2.setVisible(false);
                    } else if (heartLogo.isVisible()) {
                        heartLogo.setVisible(false);

                        BufferedWriter bw;

                        try {
                            bw = new BufferedWriter(new FileWriter("Score.txt", true));
                            bw.write(score.toString());
                            bw.newLine();
                            bw.close();
                        } catch (IOException e1) {

                            e1.printStackTrace();
                        }
                        end.page();
                        startingFrame.setVisible(false);

                    }

                    if (Questions.size() == questionAcc) {
                        BufferedWriter bw;

                        try {
                            bw = new BufferedWriter(new FileWriter("Score.txt", true));
                            bw.write(score.toString());
                            bw.newLine();
                            bw.close();
                        } catch (IOException e1) {

                            e1.printStackTrace();
                        }
                        end.page();
                        startingFrame.setVisible(false);
                    } else {
                        randomAcc++;
                        question.setText(change(question, Questions, (int) numberList.get(randomAcc)));
                        questionAcc++;
                        ans.setText("");
                    }
                }

                currScore.setText(String.valueOf(score.getScore()));
            }
        });

        ans.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (ans.getText().trim().equalsIgnoreCase(Answers.get(numberList.get(randomAcc)))) {

                    right.setText("");
                    System.out.println("right");
                    score.inceaseScore();
                    check.setText("Correct");

                    if (Questions.size() == questionAcc) {

                        BufferedWriter bw;

                        try {
                            bw = new BufferedWriter(new FileWriter("Score.txt", true));
                            bw.write(score.toString());
                            bw.newLine();
                            bw.close();
                        } catch (IOException e1) {

                            e1.printStackTrace();
                        }
                        end.page();
                        startingFrame.setVisible(false);

                    } else {

                        randomAcc++;
                        question.setText(change(question, Questions, (int) numberList.get(randomAcc)));
                        questionAcc++;
                        ans.setText("");

                    }

                } else {

                    System.out.println("Wrong answer");
                    right.setText(Answers.get(numberList.get(randomAcc)));
                    check.setText("Incorrect");

                    if (heartLogo6.isVisible()) {
                        heartLogo6.setVisible(false);
                    } else if (heartLogo5.isVisible()) {
                        heartLogo5.setVisible(false);
                    } else if (heartLogo4.isVisible()) {
                        heartLogo4.setVisible(false);
                    } else if (heartLogo3.isVisible()) {
                        heartLogo3.setVisible(false);
                    } else if (heartLogo2.isVisible()) {
                        heartLogo2.setVisible(false);
                    } else if (heartLogo.isVisible()) {
                        heartLogo.setVisible(false);

                        BufferedWriter bw;

                        try {
                            bw = new BufferedWriter(new FileWriter("Score.txt", true));
                            bw.write(score.toString());
                            bw.newLine();
                            bw.close();
                        } catch (IOException e1) {

                            e1.printStackTrace();
                        }
                        end.page();
                        startingFrame.setVisible(false);

                    }

                    if (Questions.size() == questionAcc) {
                        BufferedWriter bw;

                        try {
                            bw = new BufferedWriter(new FileWriter("Score.txt", true));
                            bw.write(score.toString());
                            bw.newLine();
                            bw.close();
                        } catch (IOException e1) {

                            e1.printStackTrace();
                        }
                        end.page();
                        startingFrame.setVisible(false);
                    } else {
                        randomAcc++;
                        question.setText(change(question, Questions, (int) numberList.get(randomAcc)));
                        questionAcc++;
                        ans.setText("");
                    }
                }

                currScore.setText(String.valueOf(score.getScore()));

            }
        });

    }

    public String change(JLabel question, HashMap Questions, int number) {

        String questions = Questions.get(number).toString();

        return questions;
    }

    public ArrayList randomNumber(ArrayList list, HashMap Questions) {

        int random = (int) (Math.random() * (Questions.size() - 0));

        while (list.size() < Questions.size()) {
            if (list.contains(random)) {
                random = (int) (Math.random() * (Questions.size() - 0));
            } else {
                list.add(random);
            }
        }

        return list;

    }
}
