package examples.swing;

import java.awt.*;
import javax.swing.*;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;

public class CountdownTimer {
  private Timer timer;
  private final JButton startButton;
  private final JLabel timeRemainingLabel;
  private final int num_seconds = 20; // 5 * 60;

  public static void main(String[] args) {
    new CountdownTimer();
  }

  public CountdownTimer() {
    var frame = new JFrame("Countdown Timer");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    var panel = new JPanel(new BorderLayout());
    startButton = new JButton("Start Countdown");
    timeRemainingLabel = label(String.valueOf(num_seconds), 500);
    panel.add(timeRemainingLabel, CENTER);
    var controlsPanel = new JPanel();
    controlsPanel.setLayout(new FlowLayout());
    controlsPanel.add(startButton);
    panel.add(label("Time left in break", 100), NORTH);
    panel.add(controlsPanel, SOUTH);
    startButton.addActionListener(e -> startTimer());
    frame.setContentPane(panel);
    frame.pack();
    frame.setVisible(true);
  }

  private JLabel label(String text, int size) {
    JLabel label = new JLabel(text);
    label.setHorizontalAlignment(SwingConstants.CENTER);
    label.setFont(new Font("Helvetica", Font.BOLD, size));
    label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
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
