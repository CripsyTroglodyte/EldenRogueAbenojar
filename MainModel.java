/**
 * This is the Main Model class. This is the Model part of the MVC.
 * 
 * @author      Fredrikzen Abenojar
 * @version     1.0 
 * @since       1.0
 */

public class MainModel{

    private String characterName;       // character name
    private JobClass selectedJobClass;  // selected job class
    private int characterLevel;         // character level
    private int characterRunes;         // character runes

    /**
     * Constructor of the JobClass
     * 
     */

    public MainModel(){
        
        characterLevel = 1; // Initial character level
        characterRunes = 50000; // Initial character runes
        
    }

    /**
     * Gets the name of your character. Can be used to display your name.
     * 
     * @return the name of your character
     */

    public String getCharacterName(){

        return characterName;

    }

    /**
     * Sets the name of your character.
     * 
     * @param characterName the name of your character
     */

    public void setCharacterName( String characterName ){

        this.characterName = characterName;

    }

    /**
     * Gets the selected job class of your character. Can be used to display your selected job class.
     * 
     * @return the selected job class of your character
     */

    public JobClass getSelectedJobClass(){

        return selectedJobClass;

    }

    /**
     * Sets the selected job class of your character.
     * 
     * @param selectedJobClass the selected job class of your character
     */

    public void setSelectedJobClass( JobClass selectedJobClass ){

        this.selectedJobClass = selectedJobClass;

    }

    /**
     * Gets the level of your character. Can be used to display your level.
     * 
     * @return the level of your character
     */

    public int getCharacterLevel(){

        return characterLevel;

    }

    /**
     * Sets the level of your character.
     * 
     * @param characterLevel the level of your character
     */

    public void setCharacterLevel( int characterLevel ){

        this.characterLevel = characterLevel;

    }

    /**
     * Gets the runes of your character. Can be used to display your runes.
     * 
     * @return the runes of your character
     */

    public int getCharacterRunes(){

        return characterRunes;

    }

    /**
     * Sets the runes of your character.
     * 
     * @param characterRunes the runes of your character
     */

    public void setCharacterRunes(int characterRunes){

        this.characterRunes = characterRunes;

    }
    
}