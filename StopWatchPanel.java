package q3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * <p>
 * The StopWatchPanel for the StopWatch program.
 * </p>
 * 
 * 
 * @author Alexandra Kabak
 * @version 1.0
 */
public class StopWatchPanel extends JPanel {

    /**
     * a random serial UID.
     */
    private static final long serialVersionUID = -377971537879931007L;
    /** JButtons start. */
    private JButton start;
    /** JButtons reset. */
    private JButton reset;
    /** JButtons stop. */
    private JButton stop;
    /** JLable for the timer to be display. */
    private JLabel display;
    /** the Timer. */
    private Timer timerSW;
    /** the number 100, which serves as the delay for the timer. */
    private final int delay = 100;
    /** the Hours. */
    private int hrs;
    /** The minutes. */
    private int mins;
    /** The Seconds. */
    private int sec;
    /** The Milliseconds. */
    private int millisec;
    /** The size of the display label. */
    private final int labelsz = 65;
    /** the number 59 used as a cap for seconds, minutes, and hours. */
    private final int sMH = 59;
    /** the number 9 used as a cap for milliseconds. */
    private final int mS = 9;

    /**
     * StopWatchPanel constructor.
     */
    public StopWatchPanel() {
        // set Layout and background.
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        

        // create JButtons and give them a bg color.
        start = new JButton("Start");
        start.setBackground(Color.lightGray);
        reset = new JButton("Reset");
        reset.setBackground(Color.lightGray);
        stop = new JButton("Stop");
        stop.setBackground(Color.lightGray);

        // create the label and give it a Font.
        display = new JLabel(hrs + ":" + mins + ":" + sec + "." + millisec,
                JLabel.CENTER);

        Font f = new Font("DS-Digital", Font.BOLD, labelsz);
        display.setForeground(Color.WHITE);

        display.setFont(f);

        // create a StopWatchListener and add it to the buttons and timer.
        StopWatchListener listener = new StopWatchListener();
        start.addActionListener(listener);
        reset.addActionListener(listener);
        stop.addActionListener(listener);

        timerSW = new Timer(delay, listener);

        // add components to the panel.
        add(display, BorderLayout.NORTH);
        add(start, BorderLayout.WEST);
        add(reset, BorderLayout.CENTER);
        add(stop, BorderLayout.EAST);

    }

    /**
     * Create the StopWatchListener, which implements the ActionListener
     * interface. This will listen for the button and timer events.
     */
    private class StopWatchListener implements ActionListener {
        /**
         * Listens for the button and timer events, and responds by executing
         * the correct code.
         * 
         * @param event
         *            the event.
         */
        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == start) {
                timerSW.start();
                start.setBackground(Color.GREEN);
                start.setText("Running");
                stop.setBackground(Color.lightGray);
                stop.setText("Stop");
            }

            if (event.getSource() == stop) {
                timerSW.stop();
                stop.setBackground(Color.RED);
                stop.setText("Stopped");
                start.setBackground(Color.lightGray);
                start.setText("Start");
            }

            if (event.getSource() == reset) {

                if (timerSW.isRunning()) {
                    timerSW.restart();

                } else if (!timerSW.isRunning()) {
                    timerSW.restart();
                    timerSW.stop();
                    stop.setBackground(Color.lightGray);
                    stop.setText("Stop");
                    start.setBackground(Color.lightGray);
                    start.setText("Start");
                }

                millisec = 0;
                sec = 0;
                mins = 0;
                hrs = 0;
                display.setText(hrs + ":" + mins + ":" + sec + "."
                        + millisec);
            }

            if (timerSW.isRunning()) {
                millisec++;

                if (millisec > mS) {
                    millisec = 0;
                    sec++;
                }
                if (sec > sMH) {
                    sec = 0;
                    mins++;
                }
                if (mins > sMH) {
                    mins = 0;
                    hrs++;
                }
                display.setText(hrs + ":" + mins + ":" + sec + "."
                        + millisec);

            }

        }
    }

}
