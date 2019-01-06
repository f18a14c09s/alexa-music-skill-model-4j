package f18a14c09s.integration.alexa.music.entities;

import lombok.Getter;

public enum ReleaseType {
    StudioAlbum("Studio Album");
    @Getter
    private final String title;

    ReleaseType(String title) {
        this.title = title;
    }
}
