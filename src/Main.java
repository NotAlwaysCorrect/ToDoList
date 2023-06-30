import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
    JLabel label1, label2;
    JPanel panel;
    JFrame frame;
    JButton addTaskButton;
    JTextField addTaskField;
    JLabel tempLabel;

    public Main() {

        frame = new JFrame();
        addTaskButton = new JButton("Add Task");
        addTaskButton.addActionListener(this);

        addTaskField = new JTextField(30);

        panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0,2));

        label1 = new JLabel("To Do List");
        label2 = new JLabel("");

        panel.add(label1);
        panel.add(label2);
        panel.add(addTaskField);
        panel.add(addTaskButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("To Do List");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed( ActionEvent e ) {

        tempLabel = new JLabel(addTaskField.getText());
        panel.add(tempLabel);
        addTaskField.setText("");

        JButton tempButton = new JButton("Delete");
        panel.add(tempButton);
        panel.validate();

        tempButton.addActionListener(e1 -> {
            panel.remove(panel.getComponentZOrder(tempButton) - 1);
            panel.remove(tempButton);
            panel.validate();
            panel.revalidate();
            panel.repaint();
        }
        );
    }
}