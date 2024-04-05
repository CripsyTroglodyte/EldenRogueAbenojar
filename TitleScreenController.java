import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the TitleScreenController class. This is where the TitleScreen's logic located.
 * 
 * @author      Fredrikzen Abenojar
 * @version     1.0 
 * @since       1.0
 */

public class TitleScreenController{

    private TitleScreenView view;       // Initiates the title screen
    private MainModel model;            // Initiates the main model

    /**
     * Constructor of the TitleScreenView class
     * @param view view
     * @param model model
     */

    public TitleScreenController( TitleScreenView view, MainModel model ){

        this.view = view;
        this.model = model;

        view.addStartButtonListener( new StartButtonListener() );
        view.addExitButtonListener( new ExitButtonListener() );

    }

    private class StartButtonListener implements ActionListener{
    
        @Override
        public void actionPerformed( ActionEvent e ){

            System.out.println("ENTERING ELDEN ROGUE...");

            CharacterCreationScreenView characterCreationScreenView = new CharacterCreationScreenView();
            characterCreationScreenView.show();

            CharacterCreationScreenController characterCreationScreenController = new CharacterCreationScreenController( characterCreationScreenView, model );

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