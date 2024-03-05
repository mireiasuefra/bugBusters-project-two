package model;

public enum Platform {
	WII("Wii"), NES("NES"), GB("GB"), DS("DS"), X360("X360"), PS3("PS3"), PS2("PS2"), SNES("SNES"), GBA("GBA"),
	_3DS("3DS"), PS4("PS4"), N64("N64"), PS5("PS5"), PC("PC"), _2600("2600"), PSP("PSP"), XONE("XOne"), WS("WS"),
	GC("GC"), WIIU("WiiU"), GEN("GEN"), PS("PS"), XB("XB"), DC("DC"), PSV("PSV"), SAT("SAT"), SCD("SCD"), NG("NG"),
	TG16("TG16"), _3DO("3DO"), GG("GG"), PCFX("PCFX"), NULL("null");

	private final String plataforma;

	private Platform(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getPlataforma() {
		return plataforma;
	}
	

	public static Platform fromString(String text) {
        for (Platform p : Platform.values()) {
            if (p.plataforma.equalsIgnoreCase(text)) {
                return p;
            }
        }
        return null;
    }
}
