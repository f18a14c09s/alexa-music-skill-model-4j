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
public class BroadcastChannelCatalogTest1 {
    /**
     * Retrieved from https://developer.amazon.com/docs/music-skills/catalog-reference.html#station-catalog-example.
     * This test case appears to be invalid, according to the structure specified for the Station entity:
     * https://developer.amazon.com/docs/music-skills/catalog-reference.html#station.
     */
    public static final String REFERENCE_TEST_CASE =
            "{   \"type\": \"AMAZON.BroadcastChannel\",   \"version\": 2.0,   \"locales\": [     {       \"country\": \"US\",       \"language\": \"en\"     }   ],   \"entities\": [     {       \"id\": \"station.001\",       \"names\": [         {           \"language\": \"en\",           \"value\": \"Today's Pop Hits\"         }       ],       \"type\": \"Live\",       \"popularity\": {         \"default\": 100,         \"overrides\": [           {             \"locale\": {               \"country\": \"US\",               \"language\": \"en\"             },             \"value\": 100           }         ]       },       \"lastUpdatedTime\": \"2018-08-01T00:00:00.000Z\",       \"locales\": [         {           \"country\": \"US\",           \"language\": \"en\"         }       ],       \"alternateNames\": [         {           \"language\": \"en\",           \"values\": [             \"Popular Music\",             \"Pop Music\",             \"Pop Hits\"           ]         }       ],       \"channelId\": 101,       \"callSign\": \"KEXP\",       \"frequency\": \"90.3\",       \"ownedAndOperated\": \"No\",       \"languageOfContent\": [         \"en\"       ],       \"deleted\": false     },     {       \"id\": \"station.002\",       \"names\": [         {           \"language\": \"en\",           \"value\": \"Classical Music\"         }       ],       \"type\": \"Recorded\",       \"popularity\": {         \"default\": 100,         \"overrides\": [           {             \"locale\": {               \"country\": \"US\",               \"language\": \"en\"             },             \"value\": 100           }         ]       },       \"lastUpdatedTime\": \"2018-08-01T00:00:00.000Z\",       \"locales\": [         {           \"country\": \"US\",           \"language\": \"en\"         }       ],       \"alternateNames\": [         {           \"language\": \"en\",           \"values\": [             \"Popular Music\",             \"Pop Music\",             \"Pop Hits\"           ]         }       ],       \"channelId\": 102,       \"ownedAndOperated\": \"No\",       \"languageOfContent\": [         \"en\"       ],       \"deleted\": false     },     {       \"id\": \"station.999\",       \"lastUpdatedTime\": \"2018-08-01T00:00:00.000Z\",       \"deleted\": true     }   ] }";
    /**
     * This is a modified version of "REFERENCE_TEST_CASE" that conforms to the structure of the ItemReference component.
     */
    public static final String MODIFIED_TEST_CASE =
            "{   \"type\": \"AMAZON.BroadcastChannel\",   \"version\": 2.0,   \"locales\": [     {       \"country\": \"US\",       \"language\": \"en\"     }   ],   \"entities\": [     {       \"id\": \"station.001\",       \"names\": [         {           \"language\": \"en\",           \"value\": \"Today's Pop Hits\"         }       ],       \"popularity\": {         \"default\": 100,         \"overrides\": [           {             \"locale\": {               \"country\": \"US\",               \"language\": \"en\"             },             \"value\": 100           }         ]       },       \"lastUpdatedTime\": \"2018-08-01T00:00:00.000Z\",       \"locales\": [         {           \"country\": \"US\",           \"language\": \"en\"         }       ],       \"alternateNames\": [         {           \"language\": \"en\",           \"values\": [             \"Popular Music\",             \"Pop Music\",             \"Pop Hits\"           ]         }       ],       \"channelId\": 101,       \"callSign\": \"KEXP\",       \"frequency\": \"90.3\",       \"ownedAndOperated\": \"No\",       \"languageOfContent\": [         \"en\"       ],       \"deleted\": false     },     {       \"id\": \"station.002\",       \"names\": [         {           \"language\": \"en\",           \"value\": \"Classical Music\"         }       ],       \"popularity\": {         \"default\": 100,         \"overrides\": [           {             \"locale\": {               \"country\": \"US\",               \"language\": \"en\"             },             \"value\": 100           }         ]       },       \"lastUpdatedTime\": \"2018-08-01T00:00:00.000Z\",       \"locales\": [         {           \"country\": \"US\",           \"language\": \"en\"         }       ],       \"alternateNames\": [         {           \"language\": \"en\",           \"values\": [             \"Popular Music\",             \"Pop Music\",             \"Pop Hits\"           ]         }       ],       \"channelId\": 102,       \"ownedAndOperated\": \"No\",       \"languageOfContent\": [         \"en\"       ],       \"deleted\": false     },     {       \"id\": \"station.999\",       \"lastUpdatedTime\": \"2018-08-01T00:00:00.000Z\",       \"deleted\": true     }   ] }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        BroadcastChannelCatalog subject = jsonMapper.readValue(MODIFIED_TEST_CASE, BroadcastChannelCatalog.class);

        assertEquals(subject.getLocales().get(0).getCountry(), US);
        assertEquals(subject.getLocales().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(0).getId(), "station.001");
        assertEquals(subject.getEntities().get(0).getNames().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(0).getNames().get(0).getValue(), "Today's Pop Hits");
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
        assertEquals(subject.getEntities().get(0).getAlternateNames().get(0).getValues().get(0), "Popular Music");
        assertEquals(subject.getEntities().get(0).getAlternateNames().get(0).getValues().get(1), "Pop Music");
        assertEquals(subject.getEntities().get(0).getAlternateNames().get(0).getValues().get(2), "Pop Hits");
        assertEquals(((Number) subject.getEntities().get(0).getChannelId()).longValue(), 101L);
        assertEquals(subject.getEntities().get(0).getCallSign(), "KEXP");
        assertEquals(subject.getEntities().get(0).getFrequency(), "90.3");
        assertEquals(subject.getEntities().get(0).getOwnedAndOperated(), "No");
        assertEquals(subject.getEntities().get(0).getLanguageOfContent().get(0), en);
        assertFalse((boolean) subject.getEntities().get(0).getDeleted());
        assertEquals(subject.getEntities().get(1).getId(), "station.002");
        assertEquals(subject.getEntities().get(1).getNames().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(1).getNames().get(0).getValue(), "Classical Music");
        assertEquals(((Number) subject.getEntities().get(1).getPopularity().getDefault()).longValue(), 100L);

        assertEquals(subject.getEntities().get(1).getPopularity().getOverrides().get(0).getLocale().getCountry(), US);
        assertEquals(subject.getEntities().get(1).getPopularity().getOverrides().get(0).getLocale().getLanguage(),
                en);
        assertEquals(((Number) subject.getEntities()
                .get(1)
                .getPopularity()
                .getOverrides()
                .get(0)
                .getValue()).longValue(), 100L);
        assertEquals(DateUtil.formatAsIso8601Utc(subject.getEntities().get(1).getLastUpdatedTime()),
                "2018-08-01T00:00:00.000Z");
        assertEquals(subject.getEntities().get(1).getLocales().get(0).getCountry(), US);
        assertEquals(subject.getEntities().get(1).getLocales().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(1).getAlternateNames().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(1).getAlternateNames().get(0).getValues().get(0), "Popular Music");
        assertEquals(subject.getEntities().get(1).getAlternateNames().get(0).getValues().get(1), "Pop Music");
        assertEquals(subject.getEntities().get(1).getAlternateNames().get(0).getValues().get(2), "Pop Hits");
        assertEquals(((Number) subject.getEntities().get(1).getChannelId()).longValue(), 102L);
        assertEquals(subject.getEntities().get(1).getOwnedAndOperated(), "No");
        assertEquals(subject.getEntities().get(1).getLanguageOfContent().get(0), en);
        assertFalse((boolean) subject.getEntities().get(1).getDeleted());
        assertEquals(subject.getEntities().get(2).getId(), "station.999");
        assertEquals(DateUtil.formatAsIso8601Utc(subject.getEntities().get(2).getLastUpdatedTime()),
                "2018-08-01T00:00:00.000Z");
        assertTrue((boolean) subject.getEntities().get(2).getDeleted());
        assertEquals(subject.getType(), "AMAZON.BroadcastChannel");
        assertEquals(((Number) subject.getVersion()).doubleValue(), 2.0D);
    }
}