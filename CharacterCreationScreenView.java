import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This is the CharacterCreationScreenView class. This is how the CharacterCreationScreen is displayed or viewed.
 * 
 * @author      Fredrikzen Abenojar
 * @version     1.0 
 * @since       1.0
 */

public class CharacterCreationScreenView{

    private JFrame frame;       // frame
    private JPanel mainPanel, formPanel, buttonPanel;       // panels
    private JLabel titleLabel, nameLabel, jobClassLabel, levelLabel, statisticsLabel, systemPromptLabel;  // labels
    private JTextField nameField;   //field
    private JButton inputNameButton, selectJobClassButton, confirmButton, exitButton;   // buttons
    private JComboBox<String> jobClassComboBox; // combo box

    /**
     * Constructor of the CharacterCreationScreenView class
     * 
     */

    public CharacterCreationScreenView(){

        initializeUI();

    }

    /**
     * Initializes the GUI of the CharacterCreationScreen for the user to view.
     * 
     */

    private void initializeUI(){

        frame = new JFrame("Character Creation");
        frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        frame.setSize(1050, 500);
        frame.setLocationRelativeTo(null);

        mainPanel = new JPanel( new BorderLayout() );
        mainPanel.setBorder( BorderFactory.createEmptyBorder(20, 20, 20, 20) );

        formPanel = new JPanel( new GridBagLayout() );
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.anchor = GridBagConstraints.WEST;

        titleLabel = new JLabel("Create Your Character");
        titleLabel.setFont( new Font("Serif", Font.BOLD, 24) );
        titleLabel.setHorizontalAlignment( SwingConstants.CENTER );
        titleLabel.setBorder( BorderFactory.createEmptyBorder(20, 0, 20, 0) );
        formPanel.add( titleLabel, constraints );

        nameLabel = new JLabel("Name:");
        nameLabel.setFont( new Font("Serif", Font.BOLD, 14) );
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.ipady = 10;
        formPanel.add( nameLabel, constraints );

        nameField = new JTextField();
        nameField.setPreferredSize( new Dimension(200, 30) );
        nameField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        constraints.gridx = 1;
        constraints.gridy = 1;
        formPanel.add( nameField, constraints );

        inputNameButton = new JButton("Input Name");
        inputNameButton.setPreferredSize(new Dimension(180, 30));
        inputNameButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        constraints.gridx = 2;
        constraints.gridy = 1;
        formPanel.add(inputNameButton, constraints);

        jobClassLabel = new JLabel("Job Class:");
        jobClassLabel.setFont( new Font("Serif", Font.BOLD, 14) );
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.ipady = 10;
        formPanel.add( jobClassLabel, constraints );

        jobClassComboBox = new JComboBox<>( new String[]{"Vagabond", "Samurai", "Warrior", "Hero", "Astrologer", "Prophet"} );
        jobClassComboBox.setPreferredSize( new Dimension(200, 30) );
        jobClassComboBox.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        constraints.gridx = 1;
        constraints.gridy = 2;
        formPanel.add( jobClassComboBox, constraints );

        selectJobClassButton = new JButton("Select Job Class");
        selectJobClassButton.setPreferredSize( new Dimension(180, 30) );
        selectJobClassButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        constraints.gridx = 2;
        constraints.gridy = 2;
        formPanel.add( selectJobClassButton, constraints );

        levelLabel = new JLabel("Level:  1");
        levelLabel.setFont( new Font("Serif", Font.BOLD, 14) );
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.ipady = 10;
        formPanel.add( levelLabel, constraints );

        statisticsLabel = new JLabel("Statistics: ");
        statisticsLabel.setFont( new Font("Serif", Font.BOLD, 14) );
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.ipady = 10;
        formPanel.add( statisticsLabel, constraints );

        systemPromptLabel = new JLabel("");
        systemPromptLabel.setFont( new Font("Serif", Font.BOLD, 14) );
        systemPromptLabel.setForeground( Color.RED );
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 3;
        formPanel.add( systemPromptLabel, constraints );

        mainPanel.add( formPanel, BorderLayout.CENTER );

        buttonPanel = new JPanel( new GridLayout(1, 2) );
        confirmButton = new JButton("Confirm");
        confirmButton.setPreferredSize( new Dimension(100, 30) );
        confirmButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        buttonPanel.add( confirmButton );

        exitButton = new JButton("Exit");
        exitButton.setPreferredSize( new Dimension(100, 30) );
        exitButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder( Color.LIGHT_GRAY, 1 ),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        buttonPanel.add( exitButton );

        mainPanel.add( buttonPanel, BorderLayout.SOUTH );

        frame.add( mainPanel );

    }

    /**
     * shows the frame
     * 
     */

    public void show(){

        frame.setVisible( true );

    }

    /**
     * gets the input of the name
     * 
     * @return the name input of what the user typed. For example the user typed his name "Bob", his name is now Bob
     */

    public String getNameInput(){

        return nameField.getText();

    }

    /**
     * gets the job class
     * 
     * @return chosen job class
     */

    public String getSelectedJobClass(){

        return ( String ) jobClassComboBox.getSelectedItem();

    }

    /**
     * Sets the level label. The level the user will always start at 1.
     * 
     * @param text level label
     */

    public void setLevelLabel( String text ){

        levelLabel.setText( text );

    }

    /**
     * Sets the Statistics label.
     * 
     * @param text Statistics label
     */

    public void setStatisticsLabel( String text ){

        statisticsLabel.setText( text );

    }

    /**
     * Sets the SystemPrompt label.
     * 
     * @param text SystemPrompt label
     */

    public void setSystemPrompt( String text ){

        systemPromptLabel.setText( text );

    }

    /**
     * add input name listener
     * 
     * @param listener listener
     */

    public void addInputNameButtonListener( ActionListener listener ){

        inputNameButton.addActionListener( listener );

    }

    /**
     * add select job class listener
     * 
     * @param listener listener
     */

    public void addSelectJobClassButtonListener( ActionListener listener ){

        selectJobClassButton.addActionListener( listener );

    }

    /**
     * add confirm listener
     * 
     * @param listener listener
     */

    public void addConfirmButtonListener( ActionListener listener ){

        confirmButton.addActionListener( listener );

    }

    /**
     * add exit listener
     * 
     * @param listener listener
     */

    public void addExitButtonListener( ActionListener listener ){

        exitButton.addActionListener( listener );

    }
    
}