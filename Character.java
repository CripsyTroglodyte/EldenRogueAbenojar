/**
 * This is the character class. This is where the you get and set the respective values of your character.
 * 
 * @author      Fredrikzen Abenojar
 * @version     1.0 
 * @since       1.0
 */

public class Character{
    
    private String name;            // Name of your character
    private JobClass jobClass;      // Job Class of your character
    private int level;              // Level of your character
    private int hp;                 // hp of your character. Depends on the Job Class chosen
    private int endurance;          // endurance of your character. Depends on the Job Class chosen
    private int dexterity;          // dexterity of your character. Depends on the Job Class chosen
    private int strength;           // strength of your character. Depends on the Job Class chosen
    private int intelligence;       // intelligence of your character. Depends on the Job Class chosen
    private int faith;              // faith of your character. Depends on the Job Class chosen

    /**
     * Sets the name of your character. 
     * 
     * @param name the name of your character
     */

    public void setName( String name ){

        this.name = name;

    }

    /**
     * Sets the class you chose. You can choose to become either 6 set classes.
     * 
     * @param jobClass the class you set.
     */

    public void setJobClass( JobClass jobClass ){

        this.jobClass = jobClass;
        this.level = 1;
        this.hp = jobClass.getHp();
        this.endurance = jobClass.getEndurance();
        this.dexterity = jobClass.getDexterity();
        this.strength = jobClass.getStrength();
        this.intelligence = jobClass.getIntelligence();
        this.faith = jobClass.getFaith();

    }

    /**
     * Gets the name of your character. Can be used to display your name.
     * 
     * @return the name of your character
     */

     public String getName(){

        return name;

    }

    /**
     * Gets the class you chose. Can be used to display your class.
     * 
     * @return the class you chose.
     */

    public JobClass getJobClass(){

        return jobClass;

    }

    /**
     * Gets the level of your character. Can be used to display your level
     * 
     * @return the level of your character
     */

    public int getLevel(){

        return level;

    }

    /**
     * Sets the level of your character. Level can change after levelling up your character using runes.
     * 
     * @param level the level of your character
     */

    public void setLevel( int level ){

        this.level = level;
        
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
     * Sets the hp of your character. Hp can increase by levelling up using runes.
     * 
     * @param hp the hp of your character.
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
     * Sets the endurance of your character. endurance can be increase by levelling up using runes.
     * 
     * @param endurance the endurance of your character
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
     * Sets the dexterity of your character. Dexterity can be increased by levelling up using runes.
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
     * Sets the strength of your character. Strength can be increased by levelling up using runes.
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
     * Sets the intelligence of your character. intelligence can be increased by levelling up using runes.
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
     * Sets the faith of your character. faith can be increased by levelling up using runes.
     * 
     * @param faith the faith of your character
     */

    public void setFaith( int faith ){

        this.faith = faith;
        
    }

}