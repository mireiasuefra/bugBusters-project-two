package BugsBusters.model;

/**
 * Genre
 * CLase enumerado para describir los distintos géneros que puede tener un juego
 * 06/03/2024
 * V1
 * BugsBusters
 */
public enum Genre {
	SPORTS("Sports"), PLATFORM("Platform"), RACING("Racing"), ROLE_PLAYING("Role-Playing"), PUZZLE("Puzzle"),
	MISC("Misc"), ACTION("Action"), SHOOTER("Shooter"), FIGHTING("Fighting"), SIMULATION("Simulation"),
	ADVENTURE("Adventure"), STRATEGY("Strategy"), NULL("null");
	
	private final String genero;
	
	/**
	 * Constructor para la clase enumerado de los distintos géneros que puede tener un juego
	 * @param genero Enumerado de los distintos géneros que puede tener un juego
	 */
    private Genre(String genero) {
        this.genero = genero;
    }
    
    /**
     * Devuelve el género del juego
     * @return Genero del juego
     */
    public String getGenero() {
        return genero;
    }
    
    /**
     * Método fromString para impimir por pantalla el género
     * @param text Texto string
     * @return Género del juego
     */
    public static Genre fromString(String text) {
        for (Genre g : Genre.values()) {
            if (g.genero.equalsIgnoreCase(text)) {
                return g;
            }
        }
        return null;
    }
}
