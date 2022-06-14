package com.company;
import javax.swing.*;
import java.awt.*;


public class GUI extends JFrame {


    public GUI() {
        super("form");

        this.setBounds(1, 1, 2000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new GridBagLayout());


        JRadioButton button52 = new JRadioButton("Канал №52");
        contentPane.add(button52);
        button52.setBounds(91, 30, 3, 4);
        JRadioButton s1 = new JRadioButton("шлюз1");
        contentPane.add(s1);
        button52.setBounds(180, 90, 3, 4);
        JRadioButton button53 = new JRadioButton("Канал №53 ");
        contentPane.add(button53);
        JRadioButton button54 = new JRadioButton("Судовой ход №54");
        contentPane.add(button54);
        JRadioButton button55 = new JRadioButton("Канал №55");
        contentPane.add(button55);
        JRadioButton s2 = new JRadioButton("шлюз2");
        contentPane.add(s2);
        JRadioButton button56= new JRadioButton("Канал №56 ");
        contentPane.add(button56);
        JRadioButton button57= new JRadioButton("Судовой ход №57 ");
        contentPane.add(button57);
        JRadioButton button58= new JRadioButton("Канал №58");
        contentPane.add(button58);
        JRadioButton s3 = new JRadioButton("шлюз 3");
        contentPane.add(s3);
        JRadioButton button59 = new JRadioButton("Канал №59 ");
        contentPane.add(button59);
        JRadioButton s4 = new JRadioButton("Шлюз №4");
        contentPane.add(s4);
        JRadioButton button60= new JRadioButton("Канал №60 ");
        contentPane.add(button60);
        JRadioButton s5= new JRadioButton("Шлюз №5");
        contentPane.add(s5);
        JRadioButton button61= new JRadioButton("Канал №61 ");
        contentPane.add(button61);
        JRadioButton button62= new JRadioButton("Канал судоходный №62 ");
        contentPane.add(button62);
        JRadioButton button63 = new JRadioButton("Канал №63");
        contentPane.add(button63);
        JRadioButton s6 = new JRadioButton("Шлюз №6");
        contentPane.add(s6);
        JRadioButton button64= new JRadioButton("Канал №64 ");
        contentPane.add(button64);


        //GridBagConstraints beginbutton = new GridBagConstraints();

       JButton beginbutton = new JButton("Начать");
        JButton endbutton = new JButton("Завершить");
        contentPane.add(beginbutton);
        contentPane.add(endbutton);




    }
}