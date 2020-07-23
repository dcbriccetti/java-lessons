package examples.swing;

import javax.swing.*;
import java.awt.*;

public class CountdownTimer {
  public static void main(String[] args) {
    var frame = new JFrame("Countdown Timer");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    var panel = new JPanel(new BorderLayout());
    var button = new JButton("Start Countdown");
    var timeRemaining = new JLabel("");
    timeRemaining.setHorizontalAlignment(SwingConstants.CENTER);
    timeRemaining.setPreferredSize(new Dimension(300, 30));
    panel.add(timeRemaining, BorderLayout.CENTER);
    panel.add(button, BorderLayout.SOUTH);
    button.addActionListener(e -> {
      var stopTime = System.currentTimeMillis() + 5 * 60 * 1_000;
      new Timer(1_000, (actionEvent) -> timeRemaining.setText(String.valueOf(
          (stopTime - System.currentTimeMillis()) / 1_000))).start();
    });
    frame.setContentPane(panel);
    frame.pack();
    frame.setVisible(true);
  }
}
