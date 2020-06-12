import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

/**
 * Aids the main application by managing reading in the pokemon data froma CSV file, as well as
 * randomly generating pokemon.  It also handles determining if a pokemon is captured or not.
 *
 * JDK version: 11.0.5 - Although I think any version to 8.0.0 should suffice
 *
 * @author  William Ritchie
 * @version 1.0.0
 * @since   02-23-2019
 */
public class PokemonGameManager {
    public static final int TOTAL_POKEMON = 707;

    private static final String POKEMON_FILE_PATH = "pokemon.csv";
    private List<Pokemon> pokemonList; // Contains all of the pokemon from the CSV file
    private Random randomNumGen;
    private Pokemon currentPokemon;

    /**
     * Default Constructor - Populates the pokemonList with Pokemon objects formed from the data in
     * the CSV file.
     */
    public PokemonGameManager() {
        pokemonList = new ArrayList<>();
        randomNumGen = new Random(System.currentTimeMillis()); // Provided with seed to help with pseudo randomness
        currentPokemon = new Pokemon();

        try {
            createPokemonList(POKEMON_FILE_PATH);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Reads in the CSV file data and creates pokemon objects, which are then used to
     * populate the list of pokemon.
     *
     * @param file - File path to the CSV file that contains the pokemon data
     * @throws IOException - Want this encase working with the file fails.
     */
    private void createPokemonList(String file) throws IOException {
        FileInputStream fStreamIn = new FileInputStream(file);
        Scanner scnr = new Scanner(fStreamIn);

        while (scnr.hasNextLine()) {
            // CSV files are comma separated
            String[] line = scnr.nextLine().split(",");
            Pokemon pokemon = new Pokemon(
                    Integer.parseInt(line[0]),
                    line[1],
                    line[2],
                    line[3],
                    Integer.parseInt(line[4]),
                    Integer.parseInt(line[5]),
                    Integer.parseInt(line[6]),
                    Integer.parseInt(line[7]),
                    Integer.parseInt(line[8]),
                    Integer.parseInt(line[9]));
            pokemonList.add(pokemon);
        }

        // Close file resources
        fStreamIn.close();
        scnr.close();
    }

    /**
     * Uses the random number generator to pick a random index into the list and return
     * the pokemon at that index.
     *
     * @return Pokemon - The randomly generated pokemon from the list of pokemon
     */
    public Pokemon generatePokemon() {
        // The input to nextInt provides a bound to the random number range
        currentPokemon = pokemonList.get(randomNumGen.nextInt(pokemonList.size() - 1));
        return currentPokemon;
    }

    /**
     * Simulate the attempted capture of a pokemon.  Compares the chance of success for a
     * pokeball against a randomly generated number.
     *
     * @param pokeBall - A pokeball that is used to attempt to capture the pokemon
     * @return boolean - True if the pokemon was successfully captured and False otherwise
     */
    public boolean attemptCapturePokemon(PokeBall pokeBall) {
        // The first check is in case this method gets called before generatePokemon is called
        if (currentPokemon.getPokeNum() != 0 && pokeBall != null) {
            Random rand = new Random();
            // The pokeball's percent success and the random number should be in the range of 0.0 to 1.0
            if (pokeBall.getPercentSuccess().compareTo(rand.nextFloat()) > 0) {
                return true;
            }
        }
        return false;
    }
}