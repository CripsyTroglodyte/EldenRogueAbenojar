import java.util.HashMap;
import java.util.Map;

/**
 * This is the Shop class. This is where the Shop blueprint is located. There are 6 types of weapons for the 6 types of job classes. In each weapon type, there are 4 weapons.
 * 
 * @author      Fredrikzen Abenojar
 * @version     1.0 
 * @since       1.0
 */

public enum Shop{

    /**
     * SHORT_SWORD Sword
     */
    SHORT_SWORD(0, 15, 0, 15, 15, 15, 1000),

    /**
     * ROGIERS_RAPIER Sword
     */
    ROGIERS_RAPIER(10, 25, 0, 35, 35, 35, 2000),

    /**
     * CODED_SWORD Sword
     */
    CODED_SWORD(20, 35, 0, 40, 40, 40, 4000),

    /**
     * SWORD_OF_NIGHT_AND_FLAME Sword
     */
    SWORD_OF_NIGHT_AND_FLAME(30, 45, 0, 55, 55, 55, 8000),

    /**
     * UCHIGATANA Katana
     */
    UCHIGATANA(20, 35, 0, 30, 0, 0, 1875),

    /**
     * MOONVEIL Katana
     */
    MOONVEIL(30, 40, 0, 45, 0, 0, 3750),

    /**
     * RIVERS_OF_BLOOD Katana
     */
    RIVERS_OF_BLOOD(40, 45, 0, 60, 0, 0, 7500),

    /**
     * HAND_OF_MALENIA Katana
     */
    HAND_OF_MALENIA(50, 50, 0, 75, 0, 0, 15000),

    /**
     * WHIP Whip
     */
    WHIP(15, 60, 0, 20, 0, 0, 1500),

    /**
     * URUMI Whip
     */
    URUMI(20, 70, 0, 40, 10, 0, 3000),

    /**
     * THORNED_WHIP Whip
     */
    THORNED_WHIP(30, 80, 0, 50, 0, 40, 5000),

    /**
     * HOSLOWS_PETAL_WHIP Whip
     */
    HOSLOWS_PETAL_WHIP(35, 90, 0, 55, 20, 20, 10000),

    /**
     * CLAYMORE Greatsword
     */
    CLAYMORE(15, 10, 0, 20, 0, 0, 3000),

    /**
     * STARSCOURGE_GREATSWORD Greatsword
     */
    STARSCOURGE_GREATSWORD(20, 15, 0, 40, 0, 20, 6000),

    /**
     * INSEPERABLE_SWORD Greatsword
     */
    INSEPERABLE_SWORD(25, 20, 0, 70, 60, 60, 12000),

    /**
     * MALIKETHS_BLACK_BLADE Greatsword
     */
    MALIKETHS_BLACK_BLADE(30, 25, 0, 80, 40, 60, 24000),

    /**
     * ASTROLOGERS_STAFF Stave
     */
    ASTROLOGERS_STAFF(5, 20, 0, 5, 25, 15, 2000),

    /**
     * ALBINAURIC_STAFF Stave
     */
    ALBINAURIC_STAFF(10, 30, 0, 10, 45, 35, 4000),

    /**
     * STAFF_OF_THE_GUILTY Stave
     */
    STAFF_OF_THE_GUILTY(15, 40, 0, 15, 65, 60, 8000),

    /**
     * CARIAN_REGAL_SCEPTER Stave
     */
    CARIAN_REGAL_SCEPTER(25, 50, 0, 20, 85, 75, 16000),

    /**
     * FINGERS_SEAL Seal
     */
    FINGERS_SEAL(10, 45, 0, 0, 15, 20, 2500),

    /**
     * GODSLAYERS_SEAL Seal
     */
    GODSLAYERS_SEAL(15, 50, 0, 0, 35, 40, 5000),

    /**
     * GOLDEN_ORDEAL_SEAL Seal
     */
    GOLDEN_ORDEAL_SEAL(20, 55, 0, 0, 65, 65, 10000),

    /**
     * DRAGON_COMMUNION_SEAL Seal
     */
    DRAGON_COMMUNION_SEAL(25, 60, 0, 0, 75, 80, 15000);

    private int hp;                 // hp of weapon
    private int endurance;          // endurance of weapon
    private int dexterity;          // dexterity of weapon
    private int strength;           // strength of weapon
    private int intelligence;       // intelligence of weapon
    private int faith;              // faith of weapon
    private int runeCost;           // runeCost of weapon

    /**
     * Constructor of the Boss class
     * 
     * @param hp the hp of the weapon
     * @param endurance the endurance of the weapon 
     * @param dexterity the dexterity of the weapon
     * @param strength the strength of the weapon
     * @param intelligence the intelligence of the weapon
     * @param faith the faith of the weapon
     * @param runeCost the runeCost of the weapon
     */

    Shop( int hp, int endurance, int dexterity, int strength, int intelligence, int faith, int runeCost ){

        this.hp = hp;
        this.endurance = endurance;
        this.dexterity = dexterity;
        this.strength = strength;
        this.intelligence = intelligence;
        this.faith = faith;
        this.runeCost = runeCost;
        
    }

    /**
     * Gets the HP of your weapon. Can be used to display your hp.
     * 
     * @return the hp of your weapon
     */

    public int getHp(){

        return hp;

    }

    /**
     * Sets the HP of your weapon.
     * 
     * @param hp the hp of your weapon
     */

    public void setHp( int hp ){

        this.hp = hp;

    }

    /**
     * Gets the endurance of your weapon. Can be used to display your endurance.
     * 
     * @return the endurance of your weapon
     */

    public int getEndurance(){

        return endurance;

    }

    /**
     * Sets the endurance of your weapon.
     * 
     * @param endurance the endurance of your weapon
     */

    public void setEndurance( int endurance ){

        this.endurance = endurance;

    }

    /**
     * Gets the dexterity of your weapon.  Can be used to display your dexterity.
     * 
     * @return the dexterity of your weapon
     */

    public int getDexterity(){

        return dexterity;
        
    }

    /**
     * Sets the dexterity of your weapon.
     * 
     * @param dexterity the dexterity of your weapon
     */

    public void setDexterity( int dexterity ){

        this.dexterity = dexterity;

    }

    /**
     * Gets the strength of your weapon. Can be used to display your strength.
     * 
     * @return the strength of your weapon
     */

    public int getStrength(){

        return strength;

    }

    /**
     * Sets the strength of your weapon.
     * 
     * @param strength the strength of your weapon
     */

    public void setStrength( int strength ){

        this.strength = strength;

    }

    /**
     * Gets the intelligence of your weapon. Can be used to display your intelligence.
     * 
     * @return the intelligence of your weapon
     */

    public int getIntelligence(){

        return intelligence;

    }

    /**
     * Sets the intelligence of your weapon.
     * 
     * @param intelligence the intelligence of your weapon
     */

    public void setIntelligence( int intelligence ){

        this.intelligence = intelligence;

    }

    /**
     * Gets the faith of your weapon. Can be used to display your faith.
     * 
     * @return the faith of your weapon
     */

    public int getFaith(){

        return faith;

    }

    /**
     * Sets the faith of your weapon.
     * 
     * @param faith the faith of your weapon
     */

    public void setFaith( int faith ){

        this.faith = faith;

    }

    /**
     * Gets the rune cost of the weapon. Can be used to display rune cost.
     * 
     * @return the rune cost of the weapon.
     */

    public int getRuneCost(){

        return runeCost;

    }

    /**
     * Sets the rune cost of your weapon.
     * 
     * @param runeCost the rune cost of your weapon
     */

    public void setRuneCost( int runeCost ){

        this.runeCost = runeCost;

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
               " Faith: " + faith +
               " Rune Cost: " + runeCost;
    }

    /**
     * Gets the items of the shop as a Hashmap instead of like arrays, or list.
     * 
     * @return items of the shop where you can buy and store in inventory.
     */

    public static Map<Integer, Shop> getItems(){

        Map<Integer, Shop> items = new HashMap<>();
        
        items.put(1, Shop.SHORT_SWORD);
        items.put(2, Shop.ROGIERS_RAPIER);
        items.put(3, Shop.CODED_SWORD);
        items.put(4, Shop.SWORD_OF_NIGHT_AND_FLAME);

        items.put(5, Shop.UCHIGATANA);
        items.put(6, Shop.MOONVEIL);
        items.put(7, Shop.RIVERS_OF_BLOOD);
        items.put(8, Shop.HAND_OF_MALENIA);

        items.put(9, Shop.WHIP);
        items.put(10, Shop.URUMI);
        items.put(11, Shop.THORNED_WHIP);
        items.put(12, Shop.HOSLOWS_PETAL_WHIP);

        items.put(13, Shop.CLAYMORE);
        items.put(14, Shop.STARSCOURGE_GREATSWORD);
        items.put(15, Shop.INSEPERABLE_SWORD);
        items.put(16, Shop.MALIKETHS_BLACK_BLADE);

        items.put(17, Shop.ASTROLOGERS_STAFF);
        items.put(18, Shop.ALBINAURIC_STAFF);
        items.put(19, Shop.STAFF_OF_THE_GUILTY);
        items.put(20, Shop.CARIAN_REGAL_SCEPTER);

        items.put(21, Shop.FINGERS_SEAL);
        items.put(22, Shop.GODSLAYERS_SEAL);
        items.put(23, Shop.GOLDEN_ORDEAL_SEAL);
        items.put(24, Shop.DRAGON_COMMUNION_SEAL);

        return items;

    }

}