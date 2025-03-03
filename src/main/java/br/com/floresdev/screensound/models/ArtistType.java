package br.com.floresdev.screensound.models;

public enum ArtistType {
    SOLO("Solo"),
    DUO("Dupla"),
    BAND("Banda");

    private final String type;

    ArtistType(String type) {
        this.type = type;
    }
    
    public static ArtistType fromString(String type) {
        for (ArtistType artistType : ArtistType.values()) {
            if (artistType.type.equalsIgnoreCase(type)) {
                return artistType;
            }
        }
        throw new IllegalArgumentException("Tipo de artista não encontrado para o tipo fornecido: " + type);
    }
}
