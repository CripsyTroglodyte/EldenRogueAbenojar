import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This is the GameLobbyView class. This is how the GameLobbyView is displayed or viewed.
 * 
 * @author      Fredrikzen Abenojar
 * @version     1.0 
 * @since       1.0
 */

public class GameLobbyView{

    private JFrame frame;   // frame
    private JPanel panel;   // panel
    private JLabel nameLabel, jobClassLabel, jobClassStatsLabel, levelLabel, runesLabel, systemPromptLabel;   // labels
    private JButton fastTravelButton, levelUpButton, inventoryButton, shopButton, quitGameButton;             // buttons

    /**
     * Constructor of the GameLobbyView class
     * 
     */

    public GameLobbyView(){

        initializeUI();

    }

    /**
     * Initializes the GUI of the GameLobbyView class
     * 
     */

    private void initializeUI() {
        frame = new JFrame("ELDEN ROGUE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400, 850);

        // Calculate the coordinates to center the window at the top of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = 0; // Top of the screen
        
        frame.setLocation(x, y);

        panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        // Set the font for the labels
        Font serifFont = new Font("Serif", Font.BOLD, 16);

        nameLabel = new JLabel("NAME:", SwingConstants.LEFT);
        nameLabel.setFont(serifFont);
        panel.add(nameLabel);

        jobClassLabel = new JLabel("JOB CLASS:", SwingConstants.LEFT);
        jobClassLabel.setFont(serifFont);
        panel.add(jobClassLabel);

        jobClassStatsLabel = new JLabel("STATISTICS: ");
        jobClassStatsLabel.setFont(serifFont);
        panel.add(jobClassStatsLabel);

        levelLabel = new JLabel("LEVEL:", SwingConstants.LEFT);
        levelLabel.setFont(serifFont);
        panel.add(levelLabel);

        runesLabel = new JLabel("RUNES:", SwingConstants.LEFT);
        runesLabel.setFont(serifFont);
        panel.add(runesLabel);

        systemPromptLabel = new JLabel();
        systemPromptLabel.setFont(serifFont);
        panel.add(systemPromptLabel);

        fastTravelButton = new JButton("FAST TRAVEL");
        fastTravelButton.setFont(new Font("Serif", Font.PLAIN, 24));
        panel.add(fastTravelButton);

        levelUpButton = new JButton("LEVEL UP");
        levelUpButton.setFont(new Font("Serif", Font.PLAIN, 24));
        panel.add(levelUpButton);

        inventoryButton = new JButton("INVENTORY");
        inventoryButton.setFont(new Font("Serif", Font.PLAIN, 24));
        panel.add(inventoryButton);

        shopButton = new JButton("SHOP");
        shopButton.setFont(new Font("Serif", Font.PLAIN, 24));
        panel.add(shopButton);

        quitGameButton = new JButton("QUIT");
        quitGameButton.setFont(new Font("Serif", Font.PLAIN, 24));
        panel.add(quitGameButton);

        frame.add(panel);
    }

    /**
     * shows the frame
     * 
     */

    public void show(){

        frame.setVisible( true );

    }

    /**
     * sets the name label
     * 
     * @param text text
     */

    public void setNameLabelText( String text ){

        nameLabel.setText( text );

    }

    /**
     * job class label
     * 
     * @param text text
     */

    public void setJobClassLabelText( String text ){

        jobClassLabel.setText( text );

    }

    /**
     * job class stats label
     * 
     * @param text text
     */

    public void setJobClassStatsLabelText( String text ){

        jobClassStatsLabel.setText( text );

    }

    /**
     * level label
     * 
     * @param text text
     */

    public void setLevelLabelText( String text ){

        levelLabel.setText( text );

    }

    /**
     * runes label
     * 
     * @param text text
     */

    public void setRunesLabelText( String text ){

        runesLabel.setText( text );

    }

    /**
     * systemprompt
     * 
     * @param prompt prompt
     */

    public void setSystemPrompt( String prompt ){

        systemPromptLabel.setText( prompt );

    }

    /**
     * add fast travel listener
     * 
     * @param listener listener
     */

    public void addFastTravelButtonListener( ActionListener listener ){

        fastTravelButton.addActionListener( listener );

    }

    /**
     * add level up listener
     * 
     * @param listener listener
     */

    public void addLevelUpButtonListener( ActionListener listener ){

        levelUpButton.addActionListener( listener );

    }

    /**
     * add Inventory listener
     * 
     * @param listener listener
     */

    public void addInventoryButtonListener( ActionListener listener ){

        inventoryButton.addActionListener( listener );

    }

    /**
     * add Shop listener
     * 
     * @param listener listener
     */

    public void addShopButtonListener( ActionListener listener ){

        shopButton.addActionListener( listener );

    }

    /**
     * add QuitGame listener
     * 
     * @param listener listener
     */

    public void addQuitGameButtonListener( ActionListener listener ){

        quitGameButton.addActionListener( listener );

    }

}