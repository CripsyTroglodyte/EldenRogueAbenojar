
public class Main {
    public static void main(String[] args) {
        // Create the main model
        MainModel model = new MainModel();

        // Create the title screen view
        TitleScreenView titleScreenView = new TitleScreenView();
        titleScreenView.show();

        // Create the title screen controller
        TitleScreenController titleScreenController = new TitleScreenController(titleScreenView, model);

        // Create the character creation screen view
        CharacterCreationScreenView characterCreationScreenView = new CharacterCreationScreenView();

        // Create the character creation screen controller
        CharacterCreationScreenController characterCreationScreenController = new CharacterCreationScreenController(characterCreationScreenView, model);

        // Create the game lobby view
        GameLobbyView gameLobbyView = new GameLobbyView();

        GameLobbyController gameLobbyController = new GameLobbyController(gameLobbyView, model);
    }
}
