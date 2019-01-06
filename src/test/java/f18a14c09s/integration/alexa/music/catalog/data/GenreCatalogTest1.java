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
public class GenreCatalogTest1 {
    public static final String TEST_CASE =
            "{   \"type\": \"AMAZON.Genre\",   \"version\": 2.0,   \"locales\": [     {       \"country\": \"US\",       \"language\": \"en\"     }   ],   \"entities\": [     {       \"id\": \"genre.001\",       \"names\": [         {           \"language\": \"en\",           \"value\": \"Rock\"         }       ],       \"popularity\": {         \"default\": 100,         \"overrides\": [           {             \"locale\": {               \"country\": \"US\",               \"language\": \"en\"             },             \"value\": 100           }         ]       },       \"lastUpdatedTime\": \"2018-08-01T00:00:00.000Z\",       \"locales\": [         {           \"country\": \"US\",           \"language\": \"en\"         }       ],       \"alternateNames\": [         {           \"language\": \"en\",           \"values\": [             \"Rock and roll\",             \"Rock 'n' roll\",             \"Classic rock\"           ]         }       ],       \"deleted\": false     },     {       \"id\": \"genre.002\",       \"names\": [         {           \"language\": \"en\",           \"value\": \"Atmospheric Electronic\"         }       ],       \"popularity\": {         \"default\": 100,         \"overrides\": [           {             \"locale\": {               \"country\": \"US\",               \"language\": \"en\"             },             \"value\": 100           }         ]       },       \"lastUpdatedTime\": \"2018-08-01T00:00:00.000Z\",       \"locales\": [         {           \"country\": \"US\",           \"language\": \"en\"         }       ],       \"alternateNames\": [         {           \"language\": \"en\",           \"values\": [             \"Ambient\"           ]         }       ],       \"deleted\": false     },     {       \"id\": \"genre.999\",       \"lastUpdatedTime\": \"2018-08-01T00:00:00.000Z\",       \"deleted\": true     }   ] }";

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        GenreCatalog subject = jsonMapper.readValue(TEST_CASE, GenreCatalog.class);

        assertEquals(subject.getLocales().get(0).getCountry(), US);
        assertEquals(subject.getLocales().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(0).getId(), "genre.001");
        assertEquals(subject.getEntities().get(0).getNames().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(0).getNames().get(0).getValue(), "Rock");
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
        assertEquals(subject.getEntities().get(0).getAlternateNames().get(0).getValues().get(0), "Rock and roll");
        assertEquals(subject.getEntities().get(0).getAlternateNames().get(0).getValues().get(1), "Rock 'n' roll");
        assertEquals(subject.getEntities().get(0).getAlternateNames().get(0).getValues().get(2), "Classic rock");
        assertFalse((boolean) subject.getEntities().get(0).getDeleted());
        assertEquals(subject.getEntities().get(1).getId(), "genre.002");
        assertEquals(subject.getEntities().get(1).getNames().get(0).getLanguage(), en);
        assertEquals(subject.getEntities().get(1).getNames().get(0).getValue(), "Atmospheric Electronic");
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
        assertEquals(subject.getEntities().get(1).getAlternateNames().get(0).getValues().get(0), "Ambient");
        assertFalse((boolean) subject.getEntities().get(1).getDeleted());
        assertEquals(subject.getEntities().get(2).getId(), "genre.999");
        assertEquals(DateUtil.formatAsIso8601Utc(subject.getEntities().get(2).getLastUpdatedTime()),
                "2018-08-01T00:00:00.000Z");
        assertTrue((boolean) subject.getEntities().get(2).getDeleted());
        assertEquals(subject.getType(), "AMAZON.Genre");
        assertEquals(((Number) subject.getVersion()).doubleValue(), 2.0D);
    }
}