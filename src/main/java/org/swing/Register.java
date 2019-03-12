package org.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by LiChaojie on 2016/12/9.
 */
public class Register extends JFrame{
    public Register(){
        JLabel jlblUserId = new JLabel("用户名：",SwingConstants.CENTER);
        JTextField jtfUserId = new JTextField(15);
        JLabel jlblPassword = new JLabel("密 码：",SwingConstants.CENTER);
        JPasswordField jtfPassword = new JPasswordField(15);
        JButton jbtOK = new JButton("确认");
        JButton jbtCancel = new JButton("取消");

        JPanel jpl1 = new JPanel(new GridLayout(2,1));
        jpl1.add(jlblUserId);
        jpl1.add(jlblPassword);

        JPanel jpl2 = new JPanel(new GridLayout(2,1));
        jpl2.add(jtfUserId);
        jpl2.add(jtfPassword);

        JPanel jplt = new JPanel(new BorderLayout());
        jplt.add(jpl1,BorderLayout.WEST);
        jplt.add(jpl2,BorderLayout.CENTER);
        jplt.add(new JLabel(),BorderLayout.NORTH);
        jplt.add(new JLabel(),BorderLayout.EAST);

        JPanel jpl3 = new JPanel(new FlowLayout());
        jpl3.add(jbtOK);
        jpl3.add(jbtCancel);

        setLayout(new GridLayout(2, 1));
        add(jplt);
        add(jpl3);

        jbtOK.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "恭喜您，注册成功！", "注册结果", JOptionPane.INFORMATION_MESSAGE);
                        new Login().display("Login");
                        setVisible(false);
                    }
                }
        );

        jbtCancel.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Login().display("Login");
                        setVisible(false);
                    }
                }
        );
    }

    public void display(String title){
        setTitle(title);
        setLocation(500,300);
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
