package org.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lichaojie on 2016/12/23.
 */
public class Source extends JFrame {
    public Source(){
        JPanel jplHeadbar = new JPanel(new GridLayout(1,3));
        jplHeadbar.add(new JLabel("文件名",SwingConstants.CENTER));
        jplHeadbar.add(new JLabel("文件类型",SwingConstants.CENTER));
        jplHeadbar.add(new JLabel("文件大小", SwingConstants.CENTER));

        JPanel jplItems = new JPanel(new GridLayout(26,3));
        for(int i = 0; i < 26 ; i ++) {
            if(i != 25){
                jplItems.add(new JLabel("Day " + (i + 1), SwingConstants.CENTER));
                jplItems.add(new JLabel(".mp3", SwingConstants.CENTER));
                jplItems.add(new JLabel((int) ((Math.random() + 1) * 10) + "M", SwingConstants.CENTER));
            }else{
                jplItems.add(new JLabel("新建文本文档",SwingConstants.CENTER));
                jplItems.add(new JLabel(".txt",SwingConstants.CENTER));
                jplItems.add(new JLabel("2.3K",SwingConstants.CENTER));
            }
        }

        jplItems.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        JScrollPane jScrollPane = new JScrollPane(jplItems);

        JButton jbtOK = new JButton("OK");
        JPanel jpl = new JPanel(new GridLayout(1,5));
        jpl.add(new JLabel());
        jpl.add(new JLabel());
        jpl.add(jbtOK);
        jpl.add(new JLabel());
        jpl.add(new JLabel());

        setLayout(new BorderLayout());
        add(jplHeadbar, BorderLayout.NORTH);
        add(jScrollPane,BorderLayout.CENTER);
        add(jpl,BorderLayout.SOUTH);

        jbtOK.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                    }
                }
        );
    }

    public void display(String title){
        setTitle(title);
        //pack();
        setLocation(500,300);
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
