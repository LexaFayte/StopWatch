package q3;

import javax.swing.JFrame;

/**
 * <p>
 * This program is a stop watch.
 * </p>
 * 
 * @author Alexandra Kabak
 * @version 1.0
 */
public class StopWatch extends JFrame {
    /**
     * random serial UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The panel width.
     */
    private static final int PW = 270;
    /**
     * The panel height.
     */
    private static final int PH = 150;

    /**
     * <p>
     * This is the main method (entry point) that gets called by the JVM.
     * </p>
     * 
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Stop Watch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StopWatchPanel panel = new StopWatchPanel();
        frame.getContentPane().add(panel);
        frame.setSize(PW, PH);
        frame.setVisible(true);

    }

};
