public class Pokemon {
    private int pokeNum; // This variable acts as a unique Id for a particular pokemon also as pokemon's unique index to the pokedex.
    private String name; // This variable holds the name of a pokemon.
    private String type1; // This variable holds first type of a pokemon.
    private String type2; // This variable holds the second type of a pokemon.
    private int hp; // This variable determines how health a pokemon has. This number decreases when it is dealt damage.
    private int attack; // This variable determines how much damage a pokemon can do.
    private int defense; // This variable determines how much damage a pokemon is dealt.
    private int specialAtk; // This variable determines how much damage a pokemon can do.
    private int specialDef; // This variable determines how much damage a pokemon is dealt.
    private int speed; // This variable determines how fast a pokemon is.

    /**
     * Default constructor : This constructor initializes every class wide integer to a
     * value of zero, and every class wide string to an empty string.
     */
    public Pokemon() {
        this.pokeNum = 0;
        this.name = "";
        this.type1 = "";
        this.type2 = "";
        this.hp = 0;
        this.attack = 0;
        this.defense = 0;
        this.specialAtk = 0;
        this.specialDef = 0;
        this.speed = 0;
    }

    /**
     * Overloaded Constructor: Set the corresponding class wide variable to be equal to the input
     * @param pokeNum
     * @param name
     * @param type1
     * @param type2
     * @param hp
     * @param attack
     * @param defense
     * @param specialAtk
     * @param specialDef
     * @param speed
     */
    public Pokemon(int pokeNum, String name, String type1, String type2, int hp, int attack, int defense, int specialAtk, int specialDef, int speed) {
        this.pokeNum = pokeNum;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAtk = specialAtk;
        this.specialDef = specialDef;
        this.speed = speed;
    }

    // Getters and setters

    public int getPokeNum() {
        return pokeNum;
    }

    public void setPokeNum(int pokeNum) {
        this.pokeNum = pokeNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpecialAtk() {
        return specialAtk;
    }

    public void setSpecialAtk(int specialAtk) {
        this.specialAtk = specialAtk;
    }

    public int getSpecialDef() {
        return specialDef;
    }

    public void setSpecialDef(int specialDef) {
        this.specialDef = specialDef;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
