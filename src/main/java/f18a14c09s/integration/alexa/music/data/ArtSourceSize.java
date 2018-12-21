package f18a14c09s.integration.alexa.music.data;

public enum ArtSourceSize {
    /**
     * recommended for images approximately 48 x 48 pixels
     */
    X_SMALL,
    /**
     * recommended for 60 x 60 pixels
     */
    SMALL,
    /**
     * recommended for 110 x 110 pixels
     */
    MEDIUM,
    /**
     * recommended for 256 x 256 pixels
     */
    LARGE,
    /**
     * recommended for 600 x 600 pixels
     */
    X_LARGE;

    /**
     * Correlates the specified dimensions with the recommended ArtSourceSize.
     *
     * @param width
     * @param height
     * @return null if either dimension is null; the recommended ArtSourceSize otherwise.
     */
    public static ArtSourceSize valueOf(Long width, Long height) {
        if (width == null || height == null) {
            return null;
        } else if (width <= 48 && height <= 48) {
            return X_SMALL;
        } else if (width <= 60 && height <= 60) {
            return SMALL;
        } else if (width <= 110 && height <= 110) {
            return MEDIUM;
        } else if (width <= 256 && height <= 256) {
            return LARGE;
        } else {
            return X_LARGE;
        }
    }
}
