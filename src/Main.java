import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main implements ActionListener {

    int count = 0;
    JLabel label;
    JLabel taskListLabels;
    JPanel panel;
    JFrame frame;
    JButton button;
    JButton addTaskButton;
    JTextField addTaskField;


    public Main() {

        frame = new JFrame();
        button = new JButton("Click me");
        taskListLabels = new JLabel("");
        addTaskButton = new JButton(new AbstractAction("Add Task") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                taskListLabels.setText(taskListLabels.getText() + "\n " + addTaskField.getText()) ;

            }
        });


        addTaskField = new JTextField(30);
        button.addActionListener(this);

        panel = new JPanel();
        label = new JLabel("Number of clicks: ");

        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0,2));
        panel.add(button);
        panel.add(label);


        panel.add(addTaskButton);
        panel.add(addTaskField);
        panel.add(taskListLabels);

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
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number of clicks: " + count);

    }
}