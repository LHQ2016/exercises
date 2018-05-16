package experiment06.service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ServerFrame {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("服务器端");

        frame.setLayout(null);

        Label label1 = new Label("消息记录：");
        label1.setFont(new Font("微软雅黑", 1, 20));
        label1.setBounds(30, 20, 100, 30);
        frame.add(label1);

        TextField textField1 = new TextField();
        textField1.setBounds(150, 20, 550, 200);
        textField1.setFont(new Font("微软雅黑", 1, 18));
        frame.add(textField1);

        Label label2 = new Label("消息发送：");
        label2.setBounds(30, 250, 100, 30);
        label2.setFont(new Font("微软雅黑", 1, 20));
        frame.add(label2);

        TextField textField2 = new TextField();
        textField2.setBounds(150, 250, 550, 100);
        textField2.setFont(new Font("微软雅黑", 1, 20));
        frame.add(textField2);

        Button button1 = new Button("侦听准备");
        Button button2 = new Button("退    出");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        button1.setBounds(150, 400, 100, 40);
        button1.setFont(new Font("微软雅黑", 1, 18));
        frame.add(button1);

        button2.setBounds(550, 400, 100, 40);
        button2.setFont(new Font("微软雅黑", 1, 18));
        frame.add(button2);

        frame.setBounds(500, 200, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
