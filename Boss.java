/**
 * This is the Boss class. This is where the Bosses blueprint is located.
 * 
 * @author      Fredrikzen Abenojar
 * @version     1.0 
 * @since       1.0
 */

public class Boss{

    private String name;                // Name of the Boss
    private int hp;                     // HP of the Boss
    private int damage;                 // Damage of the Boss
    private double physicalDefense;     // Physical Defense of the Boss
    private double sorceryDefense;      // Sorcery Defense of the Boss
    private double incantationDefense;  // Incantation Defense of the Boss

    /**
     * Constructor of the Boss class
     * 
     * @param name the name of the Boss
     * @param hp the hp of the Boss
     * @param damage the damage of the Boss
     * @param physicalDefense the physical defense of the Boss
     * @param sorceryDefense the sorcery defense of the Boss
     * @param incantationDefense the incantation defense of the Boss
     */

    public Boss( String name, int hp, int damage, double physicalDefense, double sorceryDefense, double incantationDefense ){

        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.physicalDefense = physicalDefense;
        this.sorceryDefense = sorceryDefense;
        this.incantationDefense = incantationDefense;

    }

    /**
     * Gets the name of the boss. Can be used to display the boss name.
     * 
     * @return the name of the boss
     */

    public String getName(){

        return name;

    }

    /**
     * Gets the HP of the boss. Can be used to display the Boss hp.
     * 
     * @return the HP of the boss
     */

    public int getHp(){

        return hp;

    }

    /**
     * Sets the HP of the boss.
     * 
     * @param hp the hp of the boss.
     */

    public void setHp( int hp ){

        this.hp = hp;

    }

    /**
     * Gets the damage of the boss. Can be used to display the Boss damage.
     * 
     * @return the damage of the boss
     */

    public int getDamage(){

        return damage;

    }

    /**
     * Sets the damage of the boss.
     * 
     * @param damage the damage of the boss.
     */

    public void setDamage( int damage ){

        this.damage = damage;

    }

    /**
     * Gets the Physical Defense of the boss. Can be used to display the Boss Physical Defense.
     * 
     * @return the Physical Defense of the boss
     */

    public double getPhysicalDefense(){

        return physicalDefense;

    }

    /**
     * Sets the Physical Defense of the boss.
     * 
     * @param physicalDefense the Physical Defense of the boss.
     */

    public void setPhysicalDefense( double physicalDefense ){

        this.physicalDefense = physicalDefense;

    }

    /**
     * Gets the Sorcery Defense of the boss. Can be used to display the Boss Sorcery Defense.
     * 
     * @return the Sorcery Defense of the boss
     */

    public double getSorceryDefense(){

        return sorceryDefense;

    }

    /**
     * Sets the Sorcery Defense of the boss.
     * 
     * @param sorceryDefense the Sorcery Defense of the boss.
     */

    public void setSorceryDefense( double sorceryDefense ){

        this.sorceryDefense = sorceryDefense;

    }

    /**
     * Gets the Incantation Defense of the boss. Can be used to display the Boss Incantation Defense.
     * 
     * @return the Incantation Defense of the boss
     */

    public double getIncantationDefense(){

        return incantationDefense;

    }

    /**
     * Sets the Incantation Defense of the boss.
     * 
     * @param incantationDefense the Incantation Defense of the boss.
     */
    
    public void setIncantationDefense( double incantationDefense ){

        this.incantationDefense = incantationDefense;

    }
}