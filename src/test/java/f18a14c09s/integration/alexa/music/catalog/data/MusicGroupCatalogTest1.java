package f18a14c09s.integration.alexa.music.catalog.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import f18a14c09s.integration.util.DateUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static f18a14c09s.integration.alexa.data.Country.US;
import static f18a14c09s.integration.alexa.data.Language.en;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class MusicGroupCatalogTest1 {
    public static final String TEST_CASE =
            "{   \"type\": \"AMAZON.MusicGroup\",   \"version\": 2.0,   \"locales\": [     {       \"country\": \"US\",       \"language\": \"en\"     }   ],   \"entities\": [     {       \"id\": \"artist.001\",       \"names\": [         {           \"language\": \"en\",           \"value\": \"Macklemore\"         }       ],       \"popularity\": {         \"default\": 100,         \"overrides\": [           {             \"locale\": {               \"country\": \"US\",               \"language\": \"en\"             },             \"value\": 100           }         ]       },       \"lastUpdatedTime\": \"2018-08-01T00:00:00.000Z\",       \"locales\": [         {           \"country\": \"US\",           \"language\": \"en\"         }       ],       \"alternateNames\": [         {           \"language\": \"en\",           \"values\": [             \"Ben Haggerty\",             \"Benjamin Hammond Haggerty\"           ]         }       ],       \"deleted\": false     },     {       \"id\": \"artist.002\",       \"names\": [         {           \"language\": \"en\",           \"value\": \"Modest Mouse\"         }       ],       \"popularity\": {         \"default\": 100,         \"overrides\": [           {             \"locale\": {               \"country\": \"US\",               \"language\": \"en\"             },             \"value\": 100           }         ]       },       \"lastUpdatedTime\": \"2018-08-01T00:00:00.000Z\",       \"locales\": [         {           \"country\": \"US\",           \"language\": \"en\"         }       ],       \"alternateNames\": [         {           \"language\": \"en\",           \"values\": []         }       ],       \"deleted\": false     },     {       \"id\": \"artist.003\",       \"names\": [         {           \"language\": \"en\",           \"value\": \"Alice in Chains\"         }       ],       \"popularity\": {         \"default\": 100,         \"overrides\": [           {             \"locale\": {               \"country\": \"US\",               \"language\": \"en\"             },             \"value\": 100           }         ]       },       \"lastUpdatedTime\": \"2018-08-01T00:00:00.000Z\",       \"locales\": [         {           \"country\": \"US\",           \"language\": \"en\"         }       ],       \"deleted\": false     },     {       \"id\": \"artist.999\",       \"lastUpdatedTime\": \"2018-08-01T00:00:00.000Z\",       \"deleted\": true     }   ] }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        MusicGroupCatalog subject = jsonMapper.readValue(TEST_CASE, MusicGroupCatalog.class);

        assertEquals(subject.getLocales().get(0).getCountry(), US);
        assertEquals(subject.getLocales().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(0).getId(), "artist.001");
        assertEquals(subject.getEntities().get(0).getNames().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(0).getNames().get(0).getValue(), "Macklemore");
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
        assertEquals(subject.getEntities().get(0).getAlternateNames().get(0).getValues().get(0), "Ben Haggerty");
        assertEquals(subject.getEntities().get(0).getAlternateNames().get(0).getValues().get(1),
                "Benjamin Hammond Haggerty");
        assertFalse((boolean) subject.getEntities().get(0).getDeleted());
        assertEquals(subject.getEntities().get(1).getId(), "artist.002");
        assertEquals(subject.getEntities().get(1).getNames().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(1).getNames().get(0).getValue(), "Modest Mouse");
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
        assertFalse((boolean) subject.getEntities().get(1).getDeleted());
        assertEquals(subject.getEntities().get(2).getId(), "artist.003");
        assertEquals(subject.getEntities().get(2).getNames().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(2).getNames().get(0).getValue(), "Alice in Chains");
        assertEquals(((Number) subject.getEntities().get(2).getPopularity().getDefault()).longValue(), 100L);

        assertEquals(subject.getEntities().get(2).getPopularity().getOverrides().get(0).getLocale().getCountry(), US);
        assertEquals(subject.getEntities().get(2).getPopularity().getOverrides().get(0).getLocale().getLanguage(),
                en);
        assertEquals(((Number) subject.getEntities()
                .get(2)
                .getPopularity()
                .getOverrides()
                .get(0)
                .getValue()).longValue(), 100L);
        assertEquals(DateUtil.formatAsIso8601Utc(subject.getEntities().get(2).getLastUpdatedTime()),
                "2018-08-01T00:00:00.000Z");
        assertEquals(subject.getEntities().get(2).getLocales().get(0).getCountry(), US);
        assertEquals(subject.getEntities().get(2).getLocales().get(0).getLanguage(), en);
        assertFalse((boolean) subject.getEntities().get(2).getDeleted());
        assertEquals(subject.getEntities().get(3).getId(), "artist.999");
        assertEquals(DateUtil.formatAsIso8601Utc(subject.getEntities().get(3).getLastUpdatedTime()),
                "2018-08-01T00:00:00.000Z");
        assertTrue((boolean) subject.getEntities().get(3).getDeleted());
        assertEquals(subject.getType(), "AMAZON.MusicGroup");
        assertEquals(((Number) subject.getVersion()).doubleValue(), 2.0D);
    }
}