import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the CharacterCreationScreenController class. This is where the CharacterCreationScreenController's logic located.
 * 
 * @author      Fredrikzen Abenojar
 * @version     1.0 
 * @since       1.0
 */

public class CharacterCreationScreenController{

    private CharacterCreationScreenView view;       // CharacterCreationScreenView
    private MainModel model;                        // Main Model

    /**
     * Constructor of the CharacterCreationScreenController class
     * @param view view
     * @param model model
     */

    public CharacterCreationScreenController( CharacterCreationScreenView view, MainModel model ){

        this.view = view;
        this.model = model;

        view.addInputNameButtonListener( new InputNameButtonListener() );
        view.addSelectJobClassButtonListener( new SelectJobClassButtonListener() );
        view.addConfirmButtonListener( new ConfirmButtonListener() );
        view.addExitButtonListener( new ExitButtonListener() );

        updateCharacterDetails();

    }

    /**
     * updates the character details
     * 
     */

    private void updateCharacterDetails(){

        view.setLevelLabel("Level: " + model.getCharacterLevel());
        view.setStatisticsLabel("Statistics: \n" + getJobClassStatistics());

    }

     /**
     * gets the job class statistics
     * 
     * @return the statistics
     */

    private String getJobClassStatistics(){

        JobClass selectedJobClass = model.getSelectedJobClass();

        if( selectedJobClass != null ){

            return selectedJobClass.getStatisticsAsString().replaceAll(", ", "\n");

        }else{

            return " ";

        }

    }

    private class InputNameButtonListener implements ActionListener{

        @Override
        public void actionPerformed( ActionEvent e ){

            String name = view.getNameInput();

            if( !name.isEmpty() ){

                model.setCharacterName( name );
                view.setSystemPrompt("");

            }else{

                view.setSystemPrompt("Please Input A Valid Name.");

            }

        }

    }

    private class SelectJobClassButtonListener implements ActionListener{

        @Override
        public void actionPerformed( ActionEvent e ){

            String jobClassName = view.getSelectedJobClass();

            if( jobClassName != null ){

                JobClass jobClass = JobClass.valueOf( jobClassName.toUpperCase() );
                model.setSelectedJobClass( jobClass );
                view.setSystemPrompt("");
                updateCharacterDetails();

            }

        }

    }

    private class ConfirmButtonListener implements ActionListener{

        @Override
        public void actionPerformed( ActionEvent e ){

            if( model.getCharacterName() != null && model.getSelectedJobClass() != null ){

                GameLobbyView gameLobbyView = new GameLobbyView();
                GameLobbyController gameLobbyController = new GameLobbyController( gameLobbyView, model );
    
                // Show the Game Lobby screen
                gameLobbyView.show();

            }else{

                view.setSystemPrompt("Please input character name and select job class.");

            }

        }

    }
    
    private class ExitButtonListener implements ActionListener{

        @Override
        public void actionPerformed( ActionEvent e ){
            
            System.out.println("\nEXITING ELDEN ROGUE...");
            System.exit(0);

        }

    }

}