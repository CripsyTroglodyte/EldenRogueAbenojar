import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This is the TitleScreenView class. This is how the titlescreen is displayed or viewed.
 * 
 * @author      Fredrikzen Abenojar
 * @version     1.0 
 * @since       1.0
 */

public class TitleScreenView{

    private JFrame frame;                       // frame
    private JPanel panel;                       // panel
    private JLabel titleLabel;                  // label
    private JButton startButton, exitButton;    // buttons

    /**
     * Constructor of the TitleScreenView class
     * 
     */

    public TitleScreenView(){

        initializeUI();

    }

    /**
     * Initializes the TitleScreen.
     * 
     */

    private void initializeUI(){

        frame = new JFrame("ELDEN ROGUE");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize(600, 225); // Frame size
        frame.setLocationRelativeTo( null );

        panel = new JPanel();
        panel.setLayout( new BorderLayout() );

        titleLabel = new JLabel("Elden Rogue", SwingConstants.CENTER); // Centered text
        titleLabel.setFont( new Font("Arial", Font.BOLD, 48) ); // Large and bold font
        titleLabel.setForeground( Color.ORANGE ); // Text color
        titleLabel.setOpaque( true ); // Background color for label
        titleLabel.setBackground( new Color(0x000000) ); // Black background
        titleLabel.setPreferredSize( new Dimension( frame.getWidth(), 100 ) ); // Frame size
        panel.add( titleLabel, BorderLayout.NORTH ); // Added to the top of the frame

        startButton = new JButton("Start Game"); // More descriptive button text
        startButton.setFont( new Font("Serif", Font.PLAIN, 24) ); // Font for button
        startButton.setPreferredSize( new Dimension(200, 50) ); // Size for button
        panel.add( startButton, BorderLayout.CENTER ); // Centered horizontally

        exitButton = new JButton("Exit");
        exitButton.setFont( new Font("Serif", Font.PLAIN, 24) ); // Font for button
        exitButton.setPreferredSize( new Dimension(100, 40) ); // Size for button
        panel.add( exitButton, BorderLayout.SOUTH ); // Added to the bottom of the frame

        frame.add( panel );

    }

    /**
     * shows the frame of the TitleScreen
     * 
     */

    public void show(){

        frame.setVisible( true );

    }

    /**
     * start button to enter the game
     * 
     * @param listener listener
     */

    public void addStartButtonListener( ActionListener listener ){

        startButton.addActionListener( listener );

    }

    /**
     * exit button to exit the game
     * 
     * @param listener listener
     */

    public void addExitButtonListener( ActionListener listener ){

        exitButton.addActionListener( listener );

    }
    
}