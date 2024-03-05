package model;

public enum Genre {
	SPORTS("Sports"), PLATFORM("Platform"), RACING("Racing"), ROLE_PLAYING("Role-Playing"), PUZZLE("Puzzle"),
	MISC("Misc"), ACTION("Action"), SHOOTER("Shooter"), FIGHTING("Fighting"), SIMULATION("Simulation"),
	ADVENTURE("Adventure"), STRATEGY("Strategy"), NULL("null");
	
	private final String genero;

    private Genre(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }
    
    public static Genre fromString(String text) {
        for (Genre g : Genre.values()) {
            if (g.genero.equalsIgnoreCase(text)) {
                return g;
            }
        }
        return null;
    }
}
