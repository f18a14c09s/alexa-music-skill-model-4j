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
public class MusicPlaylistCatalogTest1 {
    public static final String TEST_CASE =
            "{   \"type\": \"AMAZON.MusicPlaylist\",   \"version\": 2.0,   \"locales\": [     {       \"country\": \"US\",       \"language\": \"en\"     }   ],   \"entities\": [     {       \"id\": \"playlist.001\",       \"names\": [         {           \"language\": \"en\",           \"value\": \"Friday Night Party Mix\"         }       ],       \"popularity\": {         \"default\": 90,         \"overrides\": [           {             \"locale\": {               \"country\": \"US\",               \"language\": \"en\"             },             \"value\": 90           }         ]       },       \"lastUpdatedTime\": \"2018-08-01T00:00:00.000Z\",       \"locales\": [         {           \"country\": \"US\",           \"language\": \"en\"         }       ],       \"alternateNames\": [         {           \"language\": \"en\",           \"values\": [             \"Friday Night Party\",             \"Party Music\"           ]         }       ],       \"deleted\": false     },     {       \"id\": \"playlist.002\",       \"names\": [         {           \"language\": \"en\",           \"value\": \"Classical Focus\"         }       ],       \"popularity\": {         \"default\": 60,         \"overrides\": [           {             \"locale\": {               \"country\": \"US\",               \"language\": \"en\"             },             \"value\": 60           }         ]       },       \"lastUpdatedTime\": \"2018-08-01T00:00:00.000Z\",       \"locales\": [         {           \"country\": \"US\",           \"language\": \"en\"         }       ],       \"alternateNames\": [         {           \"language\": \"en\",           \"values\": [             \"Classical Study\"           ]         }       ],       \"deleted\": false     },     {       \"id\": \"playlist.999\",       \"lastUpdatedTime\": \"2018-08-01T00:00:00.000Z\",       \"deleted\": true     }   ] }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        MusicPlaylistCatalog subject = jsonMapper.readValue(TEST_CASE, MusicPlaylistCatalog.class);

        assertEquals(subject.getLocales().get(0).getCountry(), US);
        assertEquals(subject.getLocales().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(0).getId(), "playlist.001");
        assertEquals(subject.getEntities().get(0).getNames().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(0).getNames().get(0).getValue(), "Friday Night Party Mix");
        assertEquals(((Number) subject.getEntities().get(0).getPopularity().getDefault()).longValue(), 90L);

        assertEquals(subject.getEntities().get(0).getPopularity().getOverrides().get(0).getLocale().getCountry(), US);
        assertEquals(subject.getEntities().get(0).getPopularity().getOverrides().get(0).getLocale().getLanguage(),
                en);
        assertEquals(((Number) subject.getEntities()
                .get(0)
                .getPopularity()
                .getOverrides()
                .get(0)
                .getValue()).longValue(), 90L);
        assertEquals(DateUtil.formatAsIso8601Utc(subject.getEntities().get(0).getLastUpdatedTime()),
                "2018-08-01T00:00:00.000Z");
        assertEquals(subject.getEntities().get(0).getLocales().get(0).getCountry(), US);
        assertEquals(subject.getEntities().get(0).getLocales().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(0).getAlternateNames().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(0).getAlternateNames().get(0).getValues().get(0), "Friday Night Party");
        assertEquals(subject.getEntities().get(0).getAlternateNames().get(0).getValues().get(1), "Party Music");
        assertFalse((boolean) subject.getEntities().get(0).getDeleted());
        assertEquals(subject.getEntities().get(1).getId(), "playlist.002");
        assertEquals(subject.getEntities().get(1).getNames().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(1).getNames().get(0).getValue(), "Classical Focus");
        assertEquals(((Number) subject.getEntities().get(1).getPopularity().getDefault()).longValue(), 60L);

        assertEquals(subject.getEntities().get(1).getPopularity().getOverrides().get(0).getLocale().getCountry(), US);
        assertEquals(subject.getEntities().get(1).getPopularity().getOverrides().get(0).getLocale().getLanguage(),
                en);
        assertEquals(((Number) subject.getEntities()
                .get(1)
                .getPopularity()
                .getOverrides()
                .get(0)
                .getValue()).longValue(), 60L);
        assertEquals(DateUtil.formatAsIso8601Utc(subject.getEntities().get(1).getLastUpdatedTime()),
                "2018-08-01T00:00:00.000Z");
        assertEquals(subject.getEntities().get(1).getLocales().get(0).getCountry(), US);
        assertEquals(subject.getEntities().get(1).getLocales().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(1).getAlternateNames().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(1).getAlternateNames().get(0).getValues().get(0), "Classical Study");
        assertFalse((boolean) subject.getEntities().get(1).getDeleted());
        assertEquals(subject.getEntities().get(2).getId(), "playlist.999");
        assertEquals(DateUtil.formatAsIso8601Utc(subject.getEntities().get(2).getLastUpdatedTime()),
                "2018-08-01T00:00:00.000Z");
        assertTrue((boolean) subject.getEntities().get(2).getDeleted());
        assertEquals(subject.getType(), "AMAZON.MusicPlaylist");
        assertEquals(((Number) subject.getVersion()).doubleValue(), 2.0D);
    }
}