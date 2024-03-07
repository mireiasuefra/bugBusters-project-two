package BugsBusters.model;

/**
 * Platform
 * CLase enumerado para describir los distintas plataformas que puede tener un juego
 * 06/03/2024
 * V1
 * BugsBusters
 */
public enum Platform {
	WII("Wii"), NES("NES"), GB("GB"), DS("DS"), X360("X360"), PS3("PS3"), PS2("PS2"), SNES("SNES"), GBA("GBA"),
	_3DS("3DS"), PS4("PS4"), N64("N64"), PS5("PS5"), PC("PC"), _2600("2600"), PSP("PSP"), XONE("XOne"), WS("WS"),
	GC("GC"), WIIU("WiiU"), GEN("GEN"), PS("PS"), XB("XB"), DC("DC"), PSV("PSV"), SAT("SAT"), SCD("SCD"), NG("NG"),
	TG16("TG16"), _3DO("3DO"), GG("GG"), PCFX("PCFX"), NULL("null");

	private final String plataforma;
	
	/**
	 * Constructor para la clase enumerado para describir los distintas plataformas que puede tener un juego
	 * @param plataforma Enumerado de los distintas plataformas que puede tener un juego
	 */
	private Platform(String plataforma) {
		this.plataforma = plataforma;
	}

	/**
	 * Devuelve la plataforma del juego
	 * @return Plataforma del juego
	 */
	public String getPlataforma() {
		return plataforma;
	}
	
	/**
	 * Método fromString para impimir por pantalla la plataforma
	 * @param text Texto string
	 * @return Plataforma del juego
	 */
	public static Platform fromString(String text) {
        for (Platform p : Platform.values()) {
            if (p.plataforma.equalsIgnoreCase(text)) {
                return p;
            }
        }
        return null;
    }
}
