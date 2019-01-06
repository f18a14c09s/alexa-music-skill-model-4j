package f18a14c09s.integration.alexa.music.catalog.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import f18a14c09s.integration.util.DateUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static f18a14c09s.integration.alexa.data.Country.US;
import static f18a14c09s.integration.alexa.data.Language.en;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class MusicAlbumCatalogTest1 {
    public static final String TEST_CASE =
            "{   \"type\": \"AMAZON.MusicAlbum\",   \"version\": 2.0,   \"locales\": [     {       \"country\": \"US\",       \"language\": \"en\"     }   ],   \"entities\": [     {       \"id\": \"album.001\",       \"names\": [         {           \"language\": \"en\",           \"value\": \"Nevermind\"         }       ],       \"popularity\": {         \"default\": 100,         \"overrides\": [           {             \"locale\": {               \"country\": \"US\",               \"language\": \"en\"             },             \"value\": 100           }         ]       },       \"lastUpdatedTime\": \"2018-08-01T00:00:00.000Z\",       \"locales\": [         {           \"country\": \"US\",           \"language\": \"en\"         }       ],       \"alternateNames\": [         {           \"language\": \"en\",           \"values\": [             \"never mind\"           ]         }       ],       \"languageOfContent\": [         \"en\"       ],       \"releaseType\": \"Studio Album\",       \"artists\": [         {           \"id\": \"artist.001\",           \"names\": [             {               \"language\": \"en\",               \"value\": \"Nirvana\"             }           ],           \"alternateNames\": [             {               \"language\": \"en\",               \"values\": [                 \"Kurt Cobain\"               ]             }           ]         }       ],       \"deleted\": false     },     {       \"id\": \"album.002\",       \"names\": [         {           \"language\": \"en\",           \"value\": \"Louder Than Love\"         }       ],       \"popularity\": {         \"default\": 50,         \"overrides\": [           {             \"locale\": {               \"country\": \"US\",               \"language\": \"en\"             },             \"value\": 75           }         ]       },       \"lastUpdatedTime\": \"2018-08-01T00:00:00.000Z\",       \"locales\": [         {           \"country\": \"US\",           \"language\": \"en\"         }       ],       \"alternateNames\": [         {           \"language\": \"en\",           \"values\": []         }       ],       \"languageOfContent\": [         \"en\"       ],       \"releaseType\": \"Studio Album\",       \"artists\": [         {           \"id\": \"artist.002\",           \"names\": [             {               \"language\": \"en\",               \"value\": \"Soundgarden\"             }           ],           \"alternateNames\": [             {               \"language\": \"en\",               \"values\": [                 \"sound garden\"               ]             }           ]         }       ],       \"deleted\": false     },     {       \"id\": \"album.999\",       \"lastUpdatedTime\": \"2018-08-01T00:00:00.000Z\",       \"deleted\": true     }   ] }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        MusicAlbumCatalog subject = jsonMapper.readValue(TEST_CASE, MusicAlbumCatalog.class);

        assertEquals(subject.getLocales().get(0).getCountry(), US);
        assertEquals(subject.getLocales().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(0).getId(), "album.001");
        assertEquals(subject.getEntities().get(0).getNames().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(0).getNames().get(0).getValue(), "Nevermind");
        assertEquals(((Number) subject.getEntities().get(0).getPopularity().getDefault()).longValue(), 100L);

        assertEquals(subject.getEntities().get(0).getPopularity().getOverrides().get(0).getLocale().getCountry(), US);
        assertEquals(subject.getEntities().get(0).getPopularity().getOverrides().get(0).getLocale().getLanguage(),
                en);
        assertEquals(((Number) subject.getEntities()
                .get(0)
                .getPopularity()
                .getOverrides()
                .get(0)
                .getValue()).longValue(), 100L);
        assertEquals(DateUtil.formatAsIso8601Utc(subject.getEntities().get(0).getLastUpdatedTime()),
                "2018-08-01T00:00:00.000Z");
        assertEquals(subject.getEntities().get(0).getLocales().get(0).getCountry(), US);
        assertEquals(subject.getEntities().get(0).getLocales().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(0).getAlternateNames().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(0).getAlternateNames().get(0).getValues().get(0), "never mind");
        assertEquals(subject.getEntities().get(0).getLanguageOfContent().get(0), en);
        assertEquals(subject.getEntities().get(0).getReleaseType(), "Studio Album");
        assertEquals(subject.getEntities().get(0).getArtists().get(0).getId(), "artist.001");
        assertEquals(subject.getEntities().get(0).getArtists().get(0).getNames().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(0).getArtists().get(0).getNames().get(0).getValue(), "Nirvana");
        assertEquals(subject.getEntities().get(0).getArtists().get(0).getAlternateNames().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(0).getArtists().get(0).getAlternateNames().get(0).getValues().get(0),
                "Kurt Cobain");
        assertFalse((boolean) subject.getEntities().get(0).getDeleted());
        assertEquals(subject.getEntities().get(1).getId(), "album.002");
        assertEquals(subject.getEntities().get(1).getNames().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(1).getNames().get(0).getValue(), "Louder Than Love");
        assertEquals(((Number) subject.getEntities().get(1).getPopularity().getDefault()).longValue(), 50L);

        assertEquals(subject.getEntities().get(1).getPopularity().getOverrides().get(0).getLocale().getCountry(), US);
        assertEquals(subject.getEntities().get(1).getPopularity().getOverrides().get(0).getLocale().getLanguage(),
                en);
        assertEquals(((Number) subject.getEntities()
                .get(1)
                .getPopularity()
                .getOverrides()
                .get(0)
                .getValue()).longValue(), 75L);
        assertEquals(DateUtil.formatAsIso8601Utc(subject.getEntities().get(1).getLastUpdatedTime()),
                "2018-08-01T00:00:00.000Z");
        assertEquals(subject.getEntities().get(1).getLocales().get(0).getCountry(), US);
        assertEquals(subject.getEntities().get(1).getLocales().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(1).getAlternateNames().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(1).getLanguageOfContent().get(0), en);
        assertEquals(subject.getEntities().get(1).getReleaseType(), "Studio Album");
        assertEquals(subject.getEntities().get(1).getArtists().get(0).getId(), "artist.002");
        assertEquals(subject.getEntities().get(1).getArtists().get(0).getNames().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(1).getArtists().get(0).getNames().get(0).getValue(), "Soundgarden");
        assertEquals(subject.getEntities().get(1).getArtists().get(0).getAlternateNames().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(1).getArtists().get(0).getAlternateNames().get(0).getValues().get(0),
                "sound garden");
        assertFalse((boolean) subject.getEntities().get(1).getDeleted());
        assertEquals(subject.getEntities().get(2).getId(), "album.999");
        assertEquals(DateUtil.formatAsIso8601Utc(subject.getEntities().get(2).getLastUpdatedTime()),
                "2018-08-01T00:00:00.000Z");
        assertTrue((boolean) subject.getEntities().get(2).getDeleted());
        assertEquals(subject.getType(), "AMAZON.MusicAlbum");
        assertEquals(((Number) subject.getVersion()).doubleValue(), 2.0D);
    }
}