public class PokeBall {
    private Float percentSuccess; // This variable will be used to determine if the capture of a pokemon is successful.

    /**
     * Default constructor : sets the value of percentSuccess to 0.5
     */
    public PokeBall() {
        percentSuccess = 0.5f;
    }

    /**
     * Get percent success value
     * @return
     */
    public Float getPercentSuccess() {
        return percentSuccess;
    }
}
