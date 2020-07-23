package examples.swing;

import javax.swing.*;
import java.awt.*;

public class CountdownTimer {
  private Timer timer;
  private JButton startButton;
  private JLabel timeRemainingLabel;
  private final int num_seconds = 300;

  public static void main(String[] args) {
    new CountdownTimer().start();
  }

  private void start() {
    var frame = new JFrame("Countdown Timer");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    var panel = new JPanel(new BorderLayout());
    startButton = new JButton("Start Countdown");
    createTimeLabel();
    panel.add(timeRemainingLabel, BorderLayout.CENTER);
    panel.add(startButton, BorderLayout.SOUTH);
    startButton.addActionListener(e -> startTimer());
    frame.setContentPane(panel);
    frame.pack();
    frame.setVisible(true);
  }

  private void createTimeLabel() {
    timeRemainingLabel = new JLabel(String.valueOf(num_seconds));
    timeRemainingLabel.setHorizontalAlignment(SwingConstants.CENTER);
    var font = new Font("Helvetica", Font.BOLD, 200);
    timeRemainingLabel.setFont(font);
  }

  private void startTimer() {
    startButton.setEnabled(false);
    var stopTime = System.currentTimeMillis() + num_seconds * 1_000;
    displayTimeRemaining(timeRemainingLabel, num_seconds * 1_000);
    timer = new Timer(1_000, (actionEvent) -> handleTimerEvent(stopTime));
    timer.start();
  }

  private void handleTimerEvent(long stopTime) {
    long timeRemainingMillis = stopTime - System.currentTimeMillis();
    if (timeRemainingMillis < 0) {
      timer.stop();
      startButton.setEnabled(true);
    }
    displayTimeRemaining(timeRemainingLabel, timeRemainingMillis);
  }

  private void displayTimeRemaining(JLabel timeRemainingLabel, long timeRemainingMillis) {
    timeRemainingLabel.setText(String.valueOf(Math.round(timeRemainingMillis / 1_000f)));
  }
}
