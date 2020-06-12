import java.util.ArrayList;

public class PokemonTrainer {
    public Pokedex pokedex; // This variable holds all of the discovered pokemon.
    private ArrayList<Pokemon> capturedPokemon; // This variable holds all of the captured pokemon, specific to your trainer.
    private ArrayList<PokeBall> pokeBalls; // This variable holds the available poke balls for the trainer to use to capture

    /**
     * This constructor initializes all three of the class wide variables.
     * It then adds SIX poke balls to the pokeBalls variable.
     */
    public PokemonTrainer() {
        pokedex = new Pokedex();
        capturedPokemon = new ArrayList<>();
        pokeBalls = new ArrayList<>();
        pokeBalls.add(new PokeBall());
        pokeBalls.add(new PokeBall());
        pokeBalls.add(new PokeBall());
        pokeBalls.add(new PokeBall());
        pokeBalls.add(new PokeBall());
        pokeBalls.add(new PokeBall());
    }

    /**
     * pokemon is to be added to the capturedPokemon list.
     * @param pokemon
     */
    public void capturePokemon(Pokemon pokemon){
        capturedPokemon.add(pokemon);
    }

    /**
     * This method returns the number of capturedPokemon.
     * @return
     */
    public int numCapturedPokemon(){
        return capturedPokemon.size();
    }

    /**
     * This method returns the capturedPokemon array.
     * @return
     */
    public Pokemon[] getCapturedPokemon(){
        return capturedPokemon.toArray(new Pokemon[capturedPokemon.size()]);
    }

    /**
     * Adds the numPokeBalls balls to the pokeballs array list.
     * @param numPokeBalls
     */
    public void addPokeBalls(int numPokeBalls){
        for (int i = 0; i < numPokeBalls; i++) {
            pokeBalls.add(new PokeBall());
        }
    }

    /**
     * Return the number of poke ball's in the pokeBall's variable
     * @return
     */
    public int pokeBallCount(){
        return pokeBalls.size();
    }

    /**
     * Return a PokeBall from the pokeBall's variable and removes it.
     * null is returned if pokeBall's variable is empty
     * @return
     */
    public PokeBall throwPokeBall(){
        if(pokeBalls.size() > 0){
            PokeBall ball = pokeBalls.get(0);
            pokeBalls.remove(0);
            return ball;
        }
        return null;
    }
}
