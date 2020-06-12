import java.util.ArrayList;

public class Pokedex {
    private ArrayList<Pokemon> pokemonList; // This variable holds all of the discovered pokemon.

    public Pokedex() {
        pokemonList = new ArrayList<>(PokemonGameManager.TOTAL_POKEMON);
        for (int i = 0; i < PokemonGameManager.TOTAL_POKEMON; i++) {
            pokemonList.add(new Pokemon());
        }
    }

    /**
     * Return true if the pokemon was successfully added, and false if not
     * @param pokemon
     * @return
     */
    public boolean addPokemon(Pokemon pokemon){
        if(hasDiscovered(pokemon)){
            return false;
        }
        pokemonList.add(pokemon.getPokeNum() - 1, pokemon);
        return true;
    }

    /**
     * Return true if the pokemon has already been discovered, false if not
     * @param pokemon
     * @return
     */
    public boolean hasDiscovered(Pokemon pokemon){
        return pokemonList.get(pokemon.getPokeNum() - 1).getPokeNum() == pokemon.getPokeNum();
    }

    /**
     * Returns an array containing all of the discovered pokemon.
     * @return
     */
    public Pokemon[] getDiscoveredPokemon(){
        return pokemonList.toArray(new Pokemon[pokemonList.size()]);
    }
}
