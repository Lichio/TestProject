package org.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by LiChaojie on 2016/12/9.
 */
public class Login extends JFrame {
    public Login(){
        JLabel jlblUserId = new JLabel("用户名：",SwingConstants.CENTER);
        JTextField jtfUserId = new JTextField(15);
        JLabel jlblPassword = new JLabel("密 码：",SwingConstants.CENTER);
        JPasswordField jtfPassword = new JPasswordField(15);
        JButton jbtLogin = new JButton("登录");
        JButton jbtRegister = new JButton("注册");

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
        jpl3.add(jbtLogin);
        jpl3.add(jbtRegister);

        setLayout(new GridLayout(2, 1));
        add(jplt);
        add(jpl3);

        jbtLogin.addActionListener(
                e -> {
//                        if(!(jtfUserId.getText().equals("李超杰")&&jtfPassword.getText().equals("123456"))){
//                            JOptionPane.showMessageDialog(null, "您输入的用户名和密码不匹配", "登录结果", JOptionPane.INFORMATION_MESSAGE);
//                        }else{
//                            new Home().display("Home", jtfUserId.getText());
//                            setVisible(false);
//                        }
                    new Home().display("Home", jtfUserId.getText());
                    setVisible(false);
                }
        );

        jbtRegister.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Register().display("Register");
                        setVisible(false);
                        //getDefaultCloseOperation();
                    }
                }
        );

        jtfUserId.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                            jbtLogin.doClick();
                        }
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

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
