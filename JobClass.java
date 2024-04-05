/**
 * This is the enumaration job class. This is where each classes respective statistics is set which is then given to the character after choosing.
 * 
 * @author      Fredrikzen Abenojar
 * @version     1.0 
 * @since       1.0
 */

public enum JobClass{
    
    /**
     * Vagabond Job Class. Best Stat is HP
     */
    VAGABOND(15, 11, 13, 14, 9, 9),

    /**
     * Samurai Job Class. Best Stat is END
     */
    SAMURAI(12, 13, 15, 12, 9, 8),

    /**
     * Warrior Job Class. Best Stat is DEX
     */
    WARRIOR(11, 11, 16, 10, 10, 8),

    /**
     * Hero Job Class. Best Stat is STR
     */
    HERO(14, 12, 9, 16, 7, 8),

    /**
     * Astrologer Job Class. Best Stat is INT
     */
    ASTROLOGER(9, 9, 12, 8, 16, 7),

    /**
     * Vagabond Job Class. Best Stat is FTH
     */
    PROPHET(10, 8, 10, 11, 7, 16);

    private int hp;             // HP of the character
    private int endurance;      // END of the character
    private int dexterity;      // DEX of the character
    private int strength;       // STR of the character
    private int intelligence;   // INT of the character
    private int faith;          // FTH of the character

    /**
     * Constructor of the JobClass
     * 
     * @param hp the hp of your respective class
     * @param endurance the endurance of your respective class
     * @param dexterity the dexterity of your respective class
     * @param strength the strength of your respective class
     * @param intelligence the intelligence of your respective class
     * @param faith the faith of your respective class
     */

    JobClass( int hp, int endurance, int dexterity, int strength, int intelligence, int faith ){

        this.hp = hp;
        this.endurance = endurance;
        this.dexterity = dexterity;
        this.strength = strength;
        this.intelligence = intelligence;
        this.faith = faith;

    }

    /**
     * Gets the HP of your character. Can be used to display your hp.
     * 
     * @return the hp of your character
     */

    public int getHp(){

        return hp;

    }

    /**
     * Sets the HP of your character.
     * 
     * @param hp the hp of your character
     */

    public void setHp( int hp ){

        this.hp = hp;

    }

    /**
     * Gets the endurance of your character. Can be used to display your endurance.
     * 
     * @return the endurance of your character
     */

    public int getEndurance(){

        return endurance;

    }

    /**
     * Sets the endurance of your character.
     * 
     * @param endurance the hp of your character
     */

    public void setEndurance( int endurance ){

        this.endurance = endurance;

    }

    /**
     * Gets the dexterity of your character.  Can be used to display your dexterity.
     * 
     * @return the dexterity of your character
     */

    public int getDexterity(){

        return dexterity;
        
    }

    /**
     * Sets the dexterity of your character.
     * 
     * @param dexterity the dexterity of your character
     */

    public void setDexterity( int dexterity ){

        this.dexterity = dexterity;

    }

    /**
     * Gets the strength of your character. Can be used to display your strength.
     * 
     * @return the strength of your character
     */

    public int getStrength(){

        return strength;

    }

    /**
     * Sets the strength of your character.
     * 
     * @param strength the strength of your character
     */

    public void setStrength( int strength ){

        this.strength = strength;

    }

    /**
     * Gets the intelligence of your character. Can be used to display your intelligence.
     * 
     * @return the intelligence of your character
     */

    public int getIntelligence(){

        return intelligence;

    }

    /**
     * Sets the intelligence of your character.
     * 
     * @param intelligence the intelligence of your character
     */

    public void setIntelligence( int intelligence ){

        this.intelligence = intelligence;

    }

    /**
     * Gets the faith of your character. Can be used to display your faith.
     * 
     * @return the faith of your character
     */

    public int getFaith(){

        return faith;

    }

    /**
     * Sets the faith of your character.
     * 
     * @param faith the faith of your character
     */

    public void setFaith( int faith ){

        this.faith = faith;

    }

    /**
     * Gets the String version of the statistics. So that it will be appended in one line.
     * 
     * @return the statistics as a String.
     */

    public String getStatisticsAsString(){
        
        return "HP: " + hp +
               " Endurance: " + endurance +
               " Dexterity: " + dexterity +
               " Strength: " + strength +
               " Intelligence: " + intelligence +
               " Faith: " + faith;
    }
    
}