package gui;

import javax.swing.*;
import java.awt.*;

public class FirstFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("测试");

        frame.setLayout(new BorderLayout());
        Panel panel1 = new Panel();
        Label label1 = new Label("消息记录:");
        TextArea textArea1 = new TextArea(5, 60);
        panel1.add(label1);
        panel1.add(textArea1);
        frame.add(panel1,BorderLayout.NORTH);

        JScrollPane scroll = new JScrollPane();

        Panel panel2 = new Panel();
        Label label2 = new Label("消息记录:");
        TextArea textArea2 = new TextArea(1,60);
        panel2.add(label2);
        panel2.add(textArea2);
        frame.add(panel2,BorderLayout.CENTER);

        Panel panel3 = new Panel();
        Button button1 = new Button("侦听准备");
        Button button2 = new Button("推出");
        panel3.add(button1);
        panel3.add(button2);
        frame.add(panel3,BorderLayout.SOUTH);
        frame.setBounds(500, 200, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
