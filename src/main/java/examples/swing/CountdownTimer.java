package examples.swing;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.*;

public class CountdownTimer {
  private Timer timer;
  private final JButton startButton;
  private final JLabel timeRemainingLabel;
  private final int num_seconds = 300;

  public static void main(String[] args) {
    new CountdownTimer();
  }

  public CountdownTimer() {
    var frame = new JFrame("Countdown Timer");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    var panel = new JPanel(new BorderLayout());
    startButton = new JButton("Start Countdown");
    timeRemainingLabel = createTimeLabel();
    panel.add(timeRemainingLabel, BorderLayout.CENTER);
    panel.add(startButton, BorderLayout.SOUTH);
    startButton.addActionListener(e -> startTimer());
    frame.setContentPane(panel);
    frame.pack();
    frame.setVisible(true);
  }

  private JLabel createTimeLabel() {
    JLabel label = new JLabel(String.valueOf(num_seconds));
    label.setHorizontalAlignment(SwingConstants.CENTER);
    label.setFont(new Font("Helvetica", Font.BOLD, 200));
    return label;
  }

  private void startTimer() {
    startButton.setEnabled(false);
    var stopTime = System.currentTimeMillis() + num_seconds * 1_000;
    displayTimeRemaining(num_seconds * 1_000);
    timer = new Timer(1_000, actionEvent -> handleTimerEvent(stopTime));
    timer.start();
  }

  private void handleTimerEvent(long stopTime) {
    long timeRemainingMillis = stopTime - System.currentTimeMillis();
    if (timeRemainingMillis <= 0) {
      timer.stop();
      startButton.setEnabled(true);
    }
    displayTimeRemaining(timeRemainingMillis);
  }

  private void displayTimeRemaining(long timeRemainingMillis) {
    timeRemainingLabel.setText(String.valueOf(Math.round(timeRemainingMillis / 1_000f)));
  }
}
