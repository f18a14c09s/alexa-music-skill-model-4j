package f18a14c09s.integration.alexa.music.data;

import java.util.*;

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

    public List<ArtSourceSize> getAlternateSizesByPriority() {
        switch (this) {
            case X_SMALL:
                return Arrays.asList(SMALL, MEDIUM, LARGE, X_LARGE);
            case SMALL:
                return Arrays.asList(MEDIUM, LARGE, X_LARGE, X_SMALL);
            case MEDIUM:
                return Arrays.asList(LARGE, X_LARGE, SMALL, X_SMALL);
            case LARGE:
                return Arrays.asList(X_LARGE, MEDIUM, SMALL, X_SMALL);
            case X_LARGE:
                return Arrays.asList(LARGE, MEDIUM, SMALL, X_SMALL);
            default:
                throw new UnsupportedOperationException(String.format("Need to add support for %s to this method.",
                        this));
        }
    }

    /**
     * Correlates the specified dimensions with the recommended ArtSourceSize.
     *
     * @param width
     * @param height
     * @retval = null if either dimension is null; the recommended ArtSourceSize otherwise.
     */
    public static ArtSourceSize valueOf(Long width, Long height) {
        ArtSourceSize retval;
        if (width == null || height == null) {
            retval = null;
        } else if (width <= 48 && height <= 48) {
            retval = X_SMALL;
        } else if (width <= 60 && height <= 60) {
            retval = SMALL;
        } else if (width <= 110 && height <= 110) {
            retval = MEDIUM;
        } else if (width <= 256 && height <= 256) {
            retval = LARGE;
        } else {
            retval = X_LARGE;
        }
//        System.out.printf("%s is the recommended art source size for %s x %s.%n", retval, width, height);
        return retval;
    }
}
