import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.*;

/**
 * This is the GameLobbyController class. This is where the GameLobbyController's logic located.
 * 
 * @author      Fredrikzen Abenojar
 * @version     1.0 
 * @since       1.0
 */

public class GameLobbyController{

    private GameLobbyView view;  // GameLobbyView
    private MainModel model;     // model
    private List< Shop > playerWeapons = new ArrayList<>();   // shop list
    private Shop equippedWeapon; // equippedWeapon
    private Boss boss;          // boss

    /**
     * Constructor of the GameLobbyController class
     * @param view view
     * @param model model
     */

    public GameLobbyController( GameLobbyView view, MainModel model ){

        this.view = view;
        this.model = model;

        updateViewWithCharacterInfo();

        view.addFastTravelButtonListener( new FastTravelButtonListener() );
        view.addLevelUpButtonListener( new LevelUpButtonListener() );
        view.addInventoryButtonListener( new InventoryButtonListener() );
        view.addShopButtonListener( new ShopButtonListener() );
        view.addQuitGameButtonListener( new QuitGameButtonListener() );

        this.boss = new Boss("Godrick The Grafted", 200, 1, 0.35, 0.20, 0.15); // Initialize the Boss

    }

    /**
     * updates the character information on the GUI
     * 
     */

    private void updateViewWithCharacterInfo(){

        view.setNameLabelText("NAME: " + ( model.getCharacterName() != null ? model.getCharacterName() : "Not Set" ));
        view.setJobClassLabelText("JOB CLASS: " + ( model.getSelectedJobClass() != null ? model.getSelectedJobClass().name() : "Not Set" ));
        view.setJobClassStatsLabelText("STATISTICS: " + getJobClassStatistics());
        view.setLevelLabelText("LEVEL: " + model.getCharacterLevel());
        view.setRunesLabelText("RUNES: " + model.getCharacterRunes());

    }

    /**
     * gets the job class statistics as string
     * 
     * @return stats as string
     */

    private String getJobClassStatistics(){

        JobClass selectedJobClass = model.getSelectedJobClass();

        if( selectedJobClass != null ){

            return selectedJobClass.getStatisticsAsString();

        }else{

            return "";

        }

    }

    /**
     * opens the battle window
     * 
     */

    private void openBattleWindow(){

        JFrame battleFrame = new JFrame("Battle: " + boss.getName());
        battleFrame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        battleFrame.setSize(800, 300);
        battleFrame.setLocationRelativeTo( null ); // Center the battle window
    
        JPanel battlePanel = new JPanel( new GridLayout(5, 1) );
    
        JLabel characterNameLabel = new JLabel("Character Name: " + model.getCharacterName());
        JLabel characterHealthLabel = new JLabel("Character Health: " + model.getSelectedJobClass().getHp());
        JLabel bossNameLabel = new JLabel("Boss Name: " + boss.getName());
        JLabel bossHealthLabel = new JLabel("Boss Health: " + boss.getHp());
    
        JComboBox<String> attackTypeComboBox = new JComboBox<>( new String[]{"Physical Attack", "Sorcery Attack", "Incantation Attack"} );
        attackTypeComboBox.setSelectedIndex(0); // Sets default selection to Physical Attack
    
        JButton attackButton = new JButton("Attack");
        attackButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed( ActionEvent e ){

                int attackTypeIndex = attackTypeComboBox.getSelectedIndex();
                int characterAttack = 0;
    
                switch( attackTypeIndex ){

                    case 0: // Physical Attack

                        characterAttack = (int) (model.getSelectedJobClass().getStrength() * (1 - boss.getPhysicalDefense()));
                        break;

                    case 1: // Sorcery Attack

                        characterAttack = (int) (model.getSelectedJobClass().getIntelligence() * (1 - boss.getSorceryDefense()));
                        break;

                    case 2: // Incantation Attack

                        characterAttack = (int) (model.getSelectedJobClass().getFaith() * (1 - boss.getIncantationDefense()));
                        break;

                }
    
                // Calculates damage to the boss
                int bossHP = boss.getHp();
                bossHP -= characterAttack;
                boss.setHp(Math.max(bossHP, 0)); // Ensure boss HP doesn't go below 0
    
                // Updates boss health label
                bossHealthLabel.setText("Boss Health: " + boss.getHp());
    
                // Checks if boss is defeated
                if( boss.getHp() <= 0 ){

                    // displays victory message in green color
                    JLabel victoryMessageLabel = new JLabel("Great Enemy Felled");
                    victoryMessageLabel.setForeground( Color.GREEN );
    
                    JOptionPane.showMessageDialog(battleFrame, victoryMessageLabel, "Victory", JOptionPane.INFORMATION_MESSAGE);
                    battleFrame.dispose(); // Close battle window
                    openCreditsScreen(); // Open credits screen if the character wins
                }else{

                    bossTurn();

                }

            }

        });
    
        battlePanel.add( characterNameLabel );
        battlePanel.add( characterHealthLabel );
        battlePanel.add( bossNameLabel );
        battlePanel.add( bossHealthLabel );
        battlePanel.add( attackTypeComboBox );
        battlePanel.add( attackButton );
    
        battleFrame.add( battlePanel );
        battleFrame.setVisible( true );

    }

    /**
     * boss turn method
     * 
     */
    
    private void bossTurn(){
        
        int characterHP = model.getSelectedJobClass().getHp();
        int bossDamage = boss.getDamage();
        characterHP -= bossDamage * (1 - boss.getPhysicalDefense()); // Apply physical defense
        characterHP = Math.max(characterHP, 0); // Ensure character HP doesn't go below 0
        model.getSelectedJobClass().setHp(characterHP);
    
        view.setJobClassStatsLabelText("STATISTICS: " + getJobClassStatistics());
    
        if( characterHP <= 0 ){

            JPanel panel = new JPanel( new BorderLayout() );
            panel.setBackground( Color.BLACK );

            JLabel message = new JLabel("You Died");
            message.setFont( new Font("Serif", Font.BOLD, 24) );
            message.setForeground( Color.RED ); // Sets font color to red
            message.setHorizontalAlignment( SwingConstants.CENTER ); // Center aligns text

            panel.add( message, BorderLayout.CENTER );

            JOptionPane.showMessageDialog(null, panel, "Defeat", JOptionPane.ERROR_MESSAGE);
            System.exit(0);

        }

    }

    /**
     * opens credits scene after beating boss
     * 
     */

    private void openCreditsScreen(){

        JFrame creditsFrame = new JFrame("Credits");
        creditsFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        creditsFrame.setSize(800, 500);
        creditsFrame.setLocationRelativeTo( null ); // Centers the credits window
    
        JPanel creditsPanel = new JPanel(new GridLayout(5, 1));
        creditsPanel.setBackground( Color.BLACK );
    
        JLabel titleLabel = new JLabel("THANK YOU FOR PLAYING!", SwingConstants.CENTER);
        titleLabel.setForeground( Color.WHITE );
        titleLabel.setFont( new Font("Serif", Font.BOLD, 20) );
    
        JLabel gameNameLabel = new JLabel("ELDEN ROGUE", SwingConstants.CENTER);
        gameNameLabel.setForeground( Color.ORANGE );
        gameNameLabel.setFont( new Font("Serif", Font.BOLD, 40) );
    
        JLabel developerTitleLabel = new JLabel("DEVELOPERS", SwingConstants.CENTER);
        developerTitleLabel.setForeground( Color.ORANGE );
        developerTitleLabel.setFont( new Font("Serif", Font.BOLD, 16) );
    
        JLabel separatorLabel = new JLabel("_________________________________", SwingConstants.CENTER);
        separatorLabel.setForeground( Color.ORANGE );
        separatorLabel.setFont( new Font("Serif", Font.BOLD, 14) );
    
        JLabel developerLabel = new JLabel("Abenojar, Fredrikzen", SwingConstants.CENTER);
        developerLabel.setForeground( Color.WHITE );
        developerLabel.setFont( new Font("Serif", Font.BOLD, 16) );
    
        creditsPanel.add( titleLabel );
        creditsPanel.add( gameNameLabel );
        creditsPanel.add( developerTitleLabel );
        creditsPanel.add( separatorLabel );
        creditsPanel.add( developerLabel );
    
        creditsFrame.add( creditsPanel );
        creditsFrame.setVisible( true );
    
        creditsFrame.addWindowListener(new java.awt.event.WindowAdapter(){

            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);

            }

        });

    }

    /**
     * opens the inventory
     * 
     */

    private void openInventoryWindow(){

        JFrame inventoryFrame = new JFrame("Inventory");
        inventoryFrame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        inventoryFrame.setSize(800, 400);
        inventoryFrame.setLocationRelativeTo( null ); // Center the inventory window

        JPanel inventoryPanel = new JPanel( new BorderLayout() );

        JTextArea inventoryTextArea = new JTextArea();
        inventoryTextArea.setEditable( false );

        StringBuilder inventoryMenu = new StringBuilder();
        inventoryMenu.append("INVENTORY\n\n");

        for( int i = 0; i < playerWeapons.size(); i++ ){

            Shop weapon = playerWeapons.get(i);

            inventoryMenu.append("[").append(i + 1).append("] - Name: ").append(weapon.name()).append("\n");
            inventoryMenu.append("Dexterity: ").append(weapon.getDexterity()).append("\n");
            inventoryMenu.append("Health: ").append(weapon.getHp()).append("\n");
            inventoryMenu.append("Endurance: ").append(weapon.getEndurance()).append("\n");
            inventoryMenu.append("Strength: ").append(weapon.getStrength()).append("\n");
            inventoryMenu.append("Intelligence: ").append(weapon.getIntelligence()).append("\n");
            inventoryMenu.append("Faith: ").append(weapon.getFaith()).append("\n\n");

        }

        inventoryTextArea.setText( inventoryMenu.toString() );

        JScrollPane scrollPane = new JScrollPane( inventoryTextArea );
        inventoryPanel.add( scrollPane, BorderLayout.CENTER );

        JTextField inputField = new JTextField();
        inventoryPanel.add(inputField, BorderLayout.SOUTH);

        inputField.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed( ActionEvent e ){

                String userInput = inputField.getText();

                try{

                    int selectedIndex = Integer.parseInt(userInput) - 1;

                    if( selectedIndex >= 0 && selectedIndex < playerWeapons.size() ){

                        equipWeapon( selectedIndex );

                    }else{

                        view.setSystemPrompt("Invalid selection. Please enter a valid weapon index.");

                    }

                }catch( NumberFormatException ex ){

                    view.setSystemPrompt("Invalid input. Please enter a valid weapon index.");

                }

                inputField.setText("");

            }

        });

        inventoryFrame.add( inventoryPanel );
        inventoryFrame.setVisible( true );

    }

    /**
     * equips weapon
     * 
     * @param selectedIndex gets input from user as selected index
     */

    private void equipWeapon( int selectedIndex ){

        // Revert changes made by previously equipped weapon
        if( equippedWeapon != null ){

            revertWeaponStats( equippedWeapon );

        }
    
        equippedWeapon = playerWeapons.get(selectedIndex);
        // Increase character's stats based on the equipped weapon
        if( equippedWeapon != null ){

            JobClass selectedJobClass = model.getSelectedJobClass();
            if( selectedJobClass != null ){

                selectedJobClass.setDexterity(selectedJobClass.getDexterity() + equippedWeapon.getDexterity());
                selectedJobClass.setHp(selectedJobClass.getHp() + equippedWeapon.getHp());
                selectedJobClass.setEndurance(selectedJobClass.getEndurance() + equippedWeapon.getEndurance());
                selectedJobClass.setStrength(selectedJobClass.getStrength() + equippedWeapon.getStrength());
                selectedJobClass.setIntelligence(selectedJobClass.getIntelligence() + equippedWeapon.getIntelligence());
                selectedJobClass.setFaith(selectedJobClass.getFaith() + equippedWeapon.getFaith());

            }
        }

        view.setSystemPrompt("You have equipped " + equippedWeapon.name() + ".");
        updateViewWithCharacterInfo();

    }

    /**
     * revert weapons stats. accurately portrays equipping from one weapon to another
     * 
     * @param weapon new weapon stats
     */
    
    private void revertWeaponStats( Shop weapon ){

        JobClass selectedJobClass = model.getSelectedJobClass();

        if( selectedJobClass != null ){

            selectedJobClass.setDexterity(selectedJobClass.getDexterity() - weapon.getDexterity());
            selectedJobClass.setHp(selectedJobClass.getHp() - weapon.getHp());
            selectedJobClass.setEndurance(selectedJobClass.getEndurance() - weapon.getEndurance());
            selectedJobClass.setStrength(selectedJobClass.getStrength() - weapon.getStrength());
            selectedJobClass.setIntelligence(selectedJobClass.getIntelligence() - weapon.getIntelligence());
            selectedJobClass.setFaith(selectedJobClass.getFaith() - weapon.getFaith());

        }

    }

    /**
     * opens shop window
     * 
     */

    private void openShopWindow(){

        JFrame shopFrame = new JFrame("Shop");
        shopFrame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        shopFrame.setSize(600, 400);
        shopFrame.setLocationRelativeTo( null ); // Center the shop window
    
        JPanel shopPanel = new JPanel( new BorderLayout() ); // Set BorderLayout here
    
        JTextArea shopTextArea = new JTextArea();
        shopTextArea.setEditable( false );
    
        StringBuilder shopMenu = new StringBuilder();

        shopMenu.append("SHOP\n\n");

        for( Map.Entry<Integer, Shop> entry : Shop.getItems().entrySet() ){

            Shop item = entry.getValue();

            shopMenu.append("[").append(entry.getKey()).append("] - Rune Cost: ").append(item.getRuneCost()).append("\n");
            shopMenu.append("Name: ").append(item.name()).append("\n");
            shopMenu.append("Dexterity: ").append(item.getDexterity()).append("\n");
            shopMenu.append("Health: ").append(item.getHp()).append("\n");
            shopMenu.append("Endurance: ").append(item.getEndurance()).append("\n");
            shopMenu.append("Strength: ").append(item.getStrength()).append("\n");
            shopMenu.append("Intelligence: ").append(item.getIntelligence()).append("\n");
            shopMenu.append("Faith: ").append(item.getFaith()).append("\n\n");

        }

        shopTextArea.setText( shopMenu.toString() );
    
        JScrollPane scrollPane = new JScrollPane(shopTextArea);
        shopPanel.add(scrollPane, BorderLayout.CENTER);
    
        JTextField inputField = new JTextField();
        shopPanel.add(inputField, BorderLayout.SOUTH);
    
        inputField.addActionListener(new ShopTextFieldListener());
    
        shopFrame.add(shopPanel);
        shopFrame.setVisible(true);
    
        updateViewWithCharacterInfo();

    }

    /**
     * opens shop window and buys items
     * 
     * @param itemIndex buys item from the shop by recieving user input as index
     */
    
    private void buyItem( int itemIndex ){

        Shop selectedItem = Shop.getItems().get( itemIndex );
    
        int playerRunes = model.getCharacterRunes();
        int itemCost = selectedItem.getRuneCost();
        if( playerRunes >= itemCost ){
            
            model.setCharacterRunes( playerRunes - itemCost );
    
            playerWeapons.add( selectedItem );
    
            view.setSystemPrompt("You have purchased " + selectedItem.name() + ".");

        }else{
            
            view.setSystemPrompt("Insufficient runes to purchase " + selectedItem.name() + ".");

        }

        updateViewWithCharacterInfo();

    }

    public class FastTravelButtonListener implements ActionListener{

    @Override
        public void actionPerformed( ActionEvent e ){

            JFrame travelFrame = new JFrame("Stormveil Castle");
            travelFrame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
            travelFrame.setSize(800, 800);
            travelFrame.setLocationRelativeTo( null ); // Center the window

            JPanel gridPanel = new JPanel( new GridLayout(3, 3) );

            JButton[][] gridButtons = new JButton[3][3];

            for( int i = 0; i < 3; i++ ){

                for( int j = 0; j < 3; j++){

                    JButton button = new JButton();
                    button.setPreferredSize(new Dimension(50, 50)); // Set button size
                    gridButtons[i][j] = button;
                    gridPanel.add(button);

                }

            }

            gridButtons[0][0].setText("(P)"); // Player position
            gridButtons[0][2].setText("(T)"); // Treasure position
            gridButtons[2][2].setText("(B)"); // Boss position

            // buttons for movement
            JButton upButton = new JButton("Up");
            JButton downButton = new JButton("Down");
            JButton leftButton = new JButton("Left");
            JButton rightButton = new JButton("Right");

            // action listeners to the movement buttons
            upButton.addActionListener(new MoveActionListener(gridButtons, Direction.UP));
            downButton.addActionListener(new MoveActionListener(gridButtons, Direction.DOWN));
            leftButton.addActionListener(new MoveActionListener(gridButtons, Direction.LEFT));
            rightButton.addActionListener(new MoveActionListener(gridButtons, Direction.RIGHT));

            JPanel buttonPanel = new JPanel(new GridLayout(3, 3));
            buttonPanel.add(new JLabel()); // Empty space for layout
            buttonPanel.add(upButton);
            buttonPanel.add(new JLabel()); // Empty space for layout
            buttonPanel.add(leftButton);
            buttonPanel.add(new JLabel()); // Empty space for layout
            buttonPanel.add(rightButton);
            buttonPanel.add(new JLabel()); // Empty space for layout
            buttonPanel.add(downButton);
            buttonPanel.add(new JLabel()); // Empty space for layout

            travelFrame.add(gridPanel, BorderLayout.CENTER);
            travelFrame.add(buttonPanel, BorderLayout.SOUTH);

            travelFrame.setVisible(true);

        }

    }

    public class MoveActionListener implements ActionListener{
        
        private JButton[][] gridButtons;
        private Direction direction;

        public MoveActionListener( JButton[][] gridButtons, Direction direction ){

            this.gridButtons = gridButtons;
            this.direction = direction;

        }

        @Override
        public void actionPerformed( ActionEvent e ){

            int currentPlayerRow = -1;
            int currentPlayerCol = -1;
            for( int i = 0; i < 3; i++ ){

                for( int j = 0; j < 3; j++){

                    if( gridButtons[i][j].getText().equals("(P)") ){

                        currentPlayerRow = i;
                        currentPlayerCol = j;
                        break;

                    }

                }

            }

            int newRow = currentPlayerRow;
            int newCol = currentPlayerCol;

            switch( direction ){

                case UP:

                    newRow = Math.max(currentPlayerRow - 1, 0);
                    break;

                case DOWN:

                    newRow = Math.min(currentPlayerRow + 1, 2);
                    break;

                case LEFT:

                    newCol = Math.max(currentPlayerCol - 1, 0);
                    break;

                case RIGHT:

                    newCol = Math.min(currentPlayerCol + 1, 2);
                    break;

            }

            if( newRow == 2 && newCol == 2 ){

                openBattleWindow();

            }if( newRow == 0 && newCol == 2 ){

                System.out.println("Encountered treasure tile!"); // Debugging message
                model.setCharacterRunes(model.getCharacterRunes() + 1000); // Increase runes by 1000
                view.setSystemPrompt("You found a treasure! Runes increased by 1000.");
                gridButtons[0][2].setText(""); // Clear the current position
                updateViewWithCharacterInfo();

            }else{
                // Move the player to the new position
                gridButtons[currentPlayerRow][currentPlayerCol].setText(""); // Clear the current position
                gridButtons[newRow][newCol].setText("(P)"); // Set the player to the new position

            }

        }

    }

    enum Direction{

        UP, DOWN, LEFT, RIGHT

    }

    private class LevelUpButtonListener implements ActionListener{

        @Override
        public void actionPerformed( ActionEvent e ){

            updateViewWithCharacterInfo();
            // Calculate the rune cost for leveling up
            int levelUpRuneCost = (model.getCharacterLevel() * 100) / 2;
            
            // Check if the player has enough runes to level up
            if( model.getCharacterRunes() < levelUpRuneCost ){

                view.setSystemPrompt("Insufficient runes to level up.");
                return;

            }
            
            String levelUpMenu = "[1] - BACK\n" +
                                 "[2] - LEVEL HEALTH\n" +
                                 "[3] - LEVEL ENDURANCE\n" +
                                 "[4] - LEVEL DEXTERITY\n" +
                                 "[5] - LEVEL STRENGTH\n" +
                                 "[6] - LEVEL INTELLIGENCE\n" +
                                 "[7] - LEVEL FAITH\n\n" +
                                 "RUNE COST: " + levelUpRuneCost + "\n" +
                                 "RUNES: " + model.getCharacterRunes() + "\n" +
                                 "HEALTH: " + model.getSelectedJobClass().getHp() + "\n" +
                                 "ENDURANCE: " + model.getSelectedJobClass().getEndurance() + "\n" +
                                 "DEXTERITY: " + model.getSelectedJobClass().getDexterity() + "\n" +
                                 "STRENGTH: " + model.getSelectedJobClass().getStrength() + "\n" +
                                 "INTELLIGENCE: " + model.getSelectedJobClass().getIntelligence() + "\n" +
                                 "FAITH: " + model.getSelectedJobClass().getFaith() + "\n";
            
            view.setSystemPrompt( levelUpMenu );
            
            int selectedOption = JOptionPane.showOptionDialog(null, levelUpMenu, "Level Up", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"BACK", "HEALTH", "ENDURANCE", "DEXTERITY", "STRENGTH", "INTELLIGENCE", "FAITH"}, "1");
            
            switch( selectedOption ){

                case 1:

                    levelUpStat("Health", model.getSelectedJobClass().getHp());
                    break;

                case 2:

                    levelUpStat("Endurance", model.getSelectedJobClass().getEndurance());
                    break;

                case 3:

                    levelUpStat("Dexterity", model.getSelectedJobClass().getDexterity());
                    break;

                case 4:

                    levelUpStat("Strength", model.getSelectedJobClass().getStrength());
                    break;

                case 5:

                    levelUpStat("Intelligence", model.getSelectedJobClass().getIntelligence());
                    break;

                case 6:

                    levelUpStat("Faith", model.getSelectedJobClass().getFaith());
                    break;

                case 7:
                
                    break;

            }

        }
        
        private void levelUpStat( String statName, int currentValue ){

            // Check if the stat is already at maximum
            if( currentValue >= 50 ){

                view.setSystemPrompt(statName + " is already at its maximum value.");
                return;

            }
            
            // Deduct rune cost
            int levelUpRuneCost = (model.getCharacterLevel() * 100) / 2;
            model.setCharacterRunes(model.getCharacterRunes() - levelUpRuneCost);
            
            // Increase the selected stat by 1
            switch( statName ){

                case "Health":

                    model.getSelectedJobClass().setHp(currentValue + 1);
                    break;

                case "Endurance":

                    model.getSelectedJobClass().setEndurance(currentValue + 1);
                    break;

                case "Dexterity":

                    model.getSelectedJobClass().setDexterity(currentValue + 1);
                    break;

                case "Strength":

                    model.getSelectedJobClass().setStrength(currentValue + 1);
                    break;

                case "Intelligence":

                    model.getSelectedJobClass().setIntelligence(currentValue + 1);
                    break;

                case "Faith":

                    model.getSelectedJobClass().setFaith(currentValue + 1);
                    break;

            }
            
            // Increase player's level by 1
            model.setCharacterLevel(model.getCharacterLevel() + 1);
            
            // Update view with character information
            updateViewWithCharacterInfo();
            
            // Inform the player of the level up
            view.setSystemPrompt(statName + " has been leveled up. Current level: " + model.getCharacterLevel());
        }
    }
    

    private class InventoryButtonListener implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ){

            updateViewWithCharacterInfo();
            openInventoryWindow();

        }

    }
    

    private class ShopButtonListener implements ActionListener{

        @Override
        public void actionPerformed( ActionEvent e ){

            updateViewWithCharacterInfo();
            openShopWindow();

        }

    }

    private class ShopTextFieldListener implements ActionListener{

        @Override
        public void actionPerformed( ActionEvent e ){

            JTextField textField = (JTextField) e.getSource();
            String userInput = textField.getText();

            try{

                int itemIndex = Integer.parseInt( userInput );
                if( itemIndex >= 1 && itemIndex <= 24 ){

                    buyItem( itemIndex );

                }else{

                    view.setSystemPrompt("Invalid input. Please enter a number between 1 and 24.");

                }

            }catch( NumberFormatException ex ){

                view.setSystemPrompt("Invalid input. Please enter a valid item index.");
            }

            textField.setText(""); // Clear the text field after processing

        }

    }
    
    private class QuitGameButtonListener implements ActionListener{

        @Override
        public void actionPerformed( ActionEvent e ){

            System.out.println("\nEXITING ELDEN ROGUE...");
            System.exit(0);

        }

    }
    
}