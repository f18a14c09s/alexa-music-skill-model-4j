package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

/**
 * Contains the stream URI that Alexa sends to devices as part of an AudioPlayer play directive, along with other stream-related information such as the playback offset in milliseconds, the expiration time of the URI, and an identifier for the stream.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stream {
    /**
     * A unique opaque (to Alexa) identifier for the stream. Note that the same stream (with the same identifier) can be re-used across User and Queue instances.
     */
    private String id;
    /**
     * URI of the stream (file or audio-chunk playlist). This URI is sent to the Alexa device media player to play the content. URIs must be HTTPS.
     */
    private String uri;
    /**
     * Offset in milliseconds of where to start playback of the stream. Defaults to 0.
     */
    private Long offsetInMilliseconds;
    /**
     * ISO 8601 representation of when the stream URI expires. Use the ISO 8601 extended format with UTC offset, for example 2019-01-29T17:12:18+00:00. At the time of the skill returning a stream to Alexa, the validUntil date must be in the future, ideally at least 15 minutes, but it can be hours, days, or years in the future. This value is passed to Alexa devices in the play directive as part of the AudioResourceLocator. Defaults to roughly 60 seconds after the stream object is received from the music skill. Note the expiration of the stream URI is defined as the latest point of time when the stream can be initiated with the given URI. Once initiated, the stream should be allowed to continue to completion without expiration. For example, a 5-minute track has a validUntil value of 09:00 AM today. If the Alexa device begins streaming the track at 08:58 AM, the track should successfully play its entire 5 minute duration, ending at 09:03 AM.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssX", timezone = "UTC")
    private Calendar validUntil;

    public Stream() {
    }

    public Stream(String id, String uri, Long offsetInMilliseconds, Calendar validUntil) {
        setId(id);
        setUri(uri);
        setOffsetInMilliseconds(offsetInMilliseconds);
        setValidUntil(validUntil);
    }
}