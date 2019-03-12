package org.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by LiChaojie on 2016/12/9.
 */
public class Home extends JFrame {
    private JLabel jlblUser;

    public Home(){
        JButton jbtAll = new JButton("ȫ��");
        JButton jbtImage = new JButton("ͼƬ");
        JButton jbtAudio = new JButton("��Ƶ");
        JButton jbtVideo = new JButton("��Ƶ");
        JButton jbtDocument = new JButton("�ĵ�");
        JButton jbtProgram = new JButton("����");
        JTextField jtfSearch = new JTextField(11);
        JButton jbtSearch = new JButton("����");
        JButton jbtPublish = new JButton("����");
        JButton jbtCheck = new JButton("�鿴");

        JPanel jpl1 = new JPanel(new FlowLayout());
        jpl1.add(jbtAll);
        jpl1.add(jbtImage);

        JPanel jpl2 = new JPanel(new FlowLayout());
        jpl2.add(jbtAudio);
        jpl2.add(jbtVideo);

        JPanel jpl3 = new JPanel(new FlowLayout());
        jpl3.add(jbtDocument);
        jpl3.add(jbtProgram);

        JPanel jpl4 = new JPanel(new FlowLayout());
        jpl4.add(jtfSearch);
        JPanel jpl5 = new JPanel(new FlowLayout());
        jpl5.add(jbtSearch);
        JPanel jpl6 = new JPanel(new FlowLayout());
        jpl6.add(jbtPublish);
        jpl6.add(jbtCheck);

        JPanel jplLeft = new JPanel(new GridLayout(10,1));
        jplLeft.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        jplLeft.add(new JLabel());
        jplLeft.add(jpl1);
        jplLeft.add(jpl2);
        jplLeft.add(jpl3);
        jplLeft.add(new JLabel());
        jplLeft.add(jpl4);
        jplLeft.add(jpl5);
        jplLeft.add(new JLabel());
        jplLeft.add(jpl6);
        jplLeft.add(new JLabel());


        JPanel jplHeadbar = new JPanel(new GridLayout(1,7));
        jplHeadbar.add(new JLabel("�ļ���",SwingConstants.CENTER));
        jplHeadbar.add(new JLabel("�ļ�����",SwingConstants.CENTER));
        jplHeadbar.add(new JLabel("�ļ���С",SwingConstants.CENTER));
        jplHeadbar.add(new JLabel("ӵ����",SwingConstants.CENTER));
        jplHeadbar.add(new JLabel("IP��ַ",SwingConstants.CENTER));
        jplHeadbar.add(new JLabel("�˿ں�",SwingConstants.CENTER));
        jplHeadbar.add(new JLabel("����",SwingConstants.CENTER));

        //�ļ��б�
        JPanel jplItems = new JPanel(new GridLayout(25,7));
        for(int i = 0; i < 0 ; i ++){
            jplItems.add(new JLabel("Day " + (i + 1),SwingConstants.CENTER));
            jplItems.add(new JLabel(".mp3",SwingConstants.CENTER));
            jplItems.add(new JLabel((int)((Math.random() + 1) * 10) + "M",SwingConstants.CENTER));
            jplItems.add(new JLabel("user1",SwingConstants.CENTER));
            jplItems.add(new JLabel("10.170.16.253",SwingConstants.CENTER));
            jplItems.add(new JLabel("63228",SwingConstants.CENTER));

            JButton jbtDownload = new JButton("����");
            JProgressBar jProgressBar= new JProgressBar();
            jProgressBar.setMinimum(0);
            jProgressBar.setMaximum(100);
            jProgressBar.setValue(i * 100 / 25);
            jProgressBar.setStringPainted(true);
            jProgressBar.setPreferredSize(new Dimension(20, 2));

            if(i == 0 || i == 5){
                jplItems.add(jProgressBar);
            }else{
                jplItems.add(jbtDownload);
            }
            //jplItems.add(jbtDownload);

            jbtDownload.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JOptionPane.showMessageDialog(null, "��Ǹ������������Դ�������߲����ߣ��޷�����", "", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
            );
        }
        jplItems.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        JScrollPane jScrollPane = new JScrollPane(jplItems);

        //������
        JPanel jplProgress = new JPanel();
//        JLabel jlblProgress = new JLabel("��ǰ����",SwingConstants.CENTER);
//        jplProgress.setBorder(BorderFactory.createLineBorder(Color.GRAY));
//        JProgressBar jProgressBar= new JProgressBar();
//        jProgressBar.setMinimum(0);
//        jProgressBar.setMaximum(100);
//        jProgressBar.setValue(20);
//        jProgressBar.setStringPainted(true);
//        jProgressBar.setPreferredSize(new Dimension(200, 20));
//        jplProgress.add(jProgressBar);
//        jplProgress.add(jlblProgress);

        JPanel jplRight = new JPanel(new BorderLayout());
        jplRight.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        jplRight.add(jplHeadbar,BorderLayout.NORTH);
        jplRight.add(jScrollPane, BorderLayout.CENTER);
        jplRight.add(jplProgress,BorderLayout.SOUTH);


        JPanel jplMain = new JPanel(new BorderLayout());
        jplMain.add(jplLeft, BorderLayout.WEST);
        jplMain.add(jplRight, BorderLayout.CENTER);

        JPanel jplTop = new JPanel(new GridLayout(1,4));
        jplTop.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        jlblUser = new JLabel("",SwingConstants.CENTER);
        JLabel jlblDate = new JLabel(new Date().toString(),SwingConstants.LEFT);
        jplTop.add(jlblUser);
        jplTop.add(new JLabel());
        jplTop.add(new JLabel());
        jplTop.add(jlblDate);

        setLayout(new BorderLayout());
        add(jplTop, BorderLayout.NORTH);
        add(jplMain,BorderLayout.CENTER);

        jbtPublish.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Publish().display("publish");
                    }
                }
        );

        jbtCheck.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Source().display("source");
                    }
                }
        );
    }

    public void display(String title,String user){
        setTitle(title);
        jlblUser.setText("User:" + user);
        setLocation(350,180);
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
