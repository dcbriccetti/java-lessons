package examples.swing;

import javax.swing.*;
import java.awt.*;

public class HelloGui {
  public static void main(String[] args) {
    var frame = new JFrame("Hello, Graphical User Interface");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    var panel = new JPanel(new BorderLayout());
    var button = new JButton("Push me for a greeting");
    var message = new JLabel("");
    message.setHorizontalAlignment(SwingConstants.CENTER);
    message.setPreferredSize(new Dimension(300, 30));
    panel.add(message, BorderLayout.CENTER);
    panel.add(button, BorderLayout.SOUTH);
    button.addActionListener(e -> message.setText("Hello, Graphical User Interface"));
    frame.setContentPane(panel);
    frame.pack();
    frame.setVisible(true);
  }
}
