package org.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Lichaojie on 2016/12/23.
 */
public class Publish extends JFrame {
    public Publish(){
        JLabel jlblFile = new JLabel("File:");
        JTextField jtfFile = new JTextField(10);
        JButton jbtFile = new JButton("选择文件");

        JButton jbtPublish = new JButton("发布");
        JButton jbtCalcel = new JButton("取消");

        JPanel jpl1 = new JPanel(new FlowLayout());
        jpl1.add(jlblFile);
        jpl1.add(jtfFile);
        jpl1.add(jbtFile);
        //jpl1.add(new JLabel());

        JPanel jpl2 = new JPanel(new FlowLayout());
        jpl2.add(new JLabel());
        jpl2.add(jbtPublish);
        jpl2.add(jbtCalcel);
        jpl2.add(new JLabel());

        setLayout(new GridLayout(2, 1));
        add(jpl1);
        add(jpl2);

        jbtFile.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser jfc = new JFileChooser();
                        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                        //jfc.showDialog(new JLabel(), "File Chooser");
                        jfc.showOpenDialog(new JLabel());
                        File selectedFile = jfc.getSelectedFile();
                        if (selectedFile != null)
                            jtfFile.setText(selectedFile.getAbsolutePath());
                        else ;
                    }
                }
        );

        jbtPublish.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                    }
                }
        );

        jbtCalcel.addActionListener(
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
