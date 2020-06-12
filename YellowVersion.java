import java.util.Scanner;

/**
 * A command line application that runs the user through the process of discovering/capturing
 * various pokemon with pokeball's.  This is a single user application and does not require
 * internet access to appropriately run.
 *
 * JDK version: 11.0.5 - Although I think any version to 8.0.0 should suffice
 *
 * @author  William Ritchie
 * @version 1.0.0
 * @since   02-23-2019
 */
public class YellowVersion {
    private static Scanner scnr = new Scanner(System.in);
    private static PokemonGameManager pGameManager = new PokemonGameManager(); // Handles generation of pokemon
    private static PokemonTrainer ashCatchEm = new PokemonTrainer(); // Will hold the users information

    /**
     * The entry point to the application.
     *
     * @param args - command line arguments, these are not used for this application
     */
    public static void main (String[] args) {
        Pokemon curGeneratedPokemon;
        String userInput;
        boolean startGame = false; // Used for determining the starting phase of the application
        boolean isGameOver = false;

        // Application Starting Phase
        System.out.println("Welcome to SDSU CS108 Pokemon Yellow Version!");
        System.out.println("Would you like to begin your adventure? (Yes or No?)");

        while (!startGame) {
            userInput = scnr.nextLine().toLowerCase().trim();

            switch (userInput) {
                case "yes":
                    startGame = true;
                    break; // Continue to the next phase of the game

                case "no":
                    startGame = true;
                    System.out.println("See you next time!");
                    isGameOver = true; // This will prevent the next phase from running
                    break;

                default:
                    System.out.println("Uh oh, your input was not: Yes or No, please try again!");
            }
        }

        // Application Main Running Phase
        while(!isGameOver) {
            curGeneratedPokemon = pGameManager.generatePokemon(); // Returns a random pokemon
            isGameOver = handlePokemonAppeared(curGeneratedPokemon);
        }

        scnr.close();
    }

    /**
     * Handles the main game play which is centered around discovering and/or capturing
     * pokemon.  This method triggers the printing of the users options and handles the
     * users input.
     *
     * @param pokemon - Most recently appeared pokemon
     * @return boolean - True means continue the game, False means end the game
     */
    private static boolean handlePokemonAppeared(Pokemon pokemon) {
        String userInput;

        ashCatchEm.pokedex.addPokemon(pokemon); // The pokemon has been discovered
        printPokemonAppearedOptions(pokemon);

        // The infinite loop is not a problem since eventually a return statement will execute
        while (true) {
            userInput = scnr.nextLine().toLowerCase().trim();
            switch (userInput) {
                case "a" :
                    return attemptCapturePokemon(pokemon);

                case "b" :
                    System.out.println("You ran away!\n");
                    return false;

                case "c" :
                    System.out.println("See you next time!");
                    return true;

                default:
                    System.out.println("Uh oh, your input was not: A, B, or C; please try again!\n");
            }
        }
    }

    /**
     * Attempts to capture the pokemon.  Handles post capture attempt, in which the user
     * may view: pokemon seen, and pokemon captured, as well as purchase more pokeball's.
     *
     * @param pokemon - Most recently appeared pokemon
     * @return boolean - True means continue the game, False means end the game
     */
    private static boolean attemptCapturePokemon(Pokemon pokemon) {
        int pokeBallCount = ashCatchEm.pokeBallCount();
        String userInput;

        if (pokeBallCount == 0) {
            System.out.println("You are out of pokeball's!");
        }

        // Cannot capture pokemon with out any pokeball's
        if (pokeBallCount != 0 && pGameManager.attemptCapturePokemon(ashCatchEm.throwPokeBall())) {
            ashCatchEm.capturePokemon(pokemon);
            System.out.println("Congratulations you have captured: " + pokemon.getName() + "!\n");
        }
        else {
            System.out.println("Your attempt has failed and " + pokemon.getName() + " has ran away!\n");
        }

        // The infinite loop is not a problem since eventually a return statement will execute
        while (true) {
            printPostPokemonAppearedOptions();
            userInput = scnr.nextLine().toLowerCase().trim();

            switch (userInput) {
                case "a" :
                    return false;

                case "b" :
                    if (ashCatchEm.numCapturedPokemon() != 0) {
                        System.out.println("Your captured pokemon are: ");
                        printPokemon(ashCatchEm.getCapturedPokemon());
                    }
                    else {
                        System.out.println("You haven't captured any pokemon yet!\n");
                    }
                    break;

                case "c" :
                    System.out.println("The pokemon you have discovered are: ");
                    printPokemon(ashCatchEm.pokedex.getDiscoveredPokemon());
                    break;

                case "d" :
                    ashCatchEm.addPokeBalls(10);
                    System.out.println("You have purchased 10 pokeballs! You now have: " + ashCatchEm.pokeBallCount() + " PokeBalls!\n");
                    break;
                case "e" :
                    System.out.println("See you next time!");
                    return true;

                default:
                    System.out.println("Uh oh, your input was not: A, B, C, or D; please try again!\n");
            }
        }
    }

    /**
     * Prints the options a user can take once a pokemon as appeared.
     *
     * @param pokemon - Most recently appeared pokemon
     */
    private static void printPokemonAppearedOptions(Pokemon pokemon) {
        System.out.println("A wild " + pokemon.getName() + " appeared!\n");
        System.out.println("Would you like to:");
        System.out.println("    A. Attempt to capture the pokemon?");
        System.out.println("    B. Run away?");
        System.out.println("    C. End the game?\n");
    }

    /**
     * Prints the options a user can take after they have failed an attempt to capture
     * the pokemon.
     */
    private static void printPostPokemonAppearedOptions() {
        System.out.println("Would you like to:");
        System.out.println("    A. Continue Playing?");
        System.out.println("    B. View your captured Pokemon?");
        System.out.println("    C. View your Pokedex?");
        System.out.println("    D. Purchase PokeBalls?");
        System.out.println("    E. End the game?\n");
    }

    /**
     * Prints the array of pokemon and their stats based on ascending order of their array positions.
     *
     * @param pokemonArray - An array of pokemon to be printed
     */
    private static void printPokemon(Pokemon[] pokemonArray) {
        for (Pokemon pokemon : pokemonArray) {
            System.out.println("Pokedex Number: " + pokemon.getPokeNum()
                    + " Name: " + pokemon.getName()
                    + " Type1: " + pokemon.getType1()
                    + " Type2: " + pokemon.getType2()
                    + " HP: " + pokemon.getHp()
                    + " Attack: " + pokemon.getAttack()
                    + " Defense: " + pokemon.getDefense()
                    + " Special Attack: " + pokemon.getSpecialAtk()
                    + " Special Defense: " + pokemon.getSpecialDef()
                    + " Speed: " + pokemon.getSpeed()
            );
        }
        System.out.println();
    }
}
