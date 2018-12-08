package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class ResolvedSelectionCriteria {
    private String rawSelectionCriteriaId;
    private ArrayList<BaseAttribute> attributes;

    @Getter
    @Setter
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", defaultImpl = BasicEntityAttribute.class, visible = true)
    @JsonSubTypes({@JsonSubTypes.Type(value = MediaTypeAttribute.class, name = EntityTypeName.MEDIA_TYPE),
            @JsonSubTypes.Type(value = SortTypeAttribute.class, name = EntityTypeName.SORT_TYPE)})
    public abstract static class BaseAttribute {
        private EntityType type;

        protected BaseAttribute(EntityType type) {
            this.type = type;
        }
    }

    @Getter
    @Setter
    public static final class BasicEntityAttribute extends BaseAttribute {
        private String entityId;

        public BasicEntityAttribute() {
            this(null);
        }

        public BasicEntityAttribute(EntityType type) {
            super(type);
        }
    }

    @Getter
    @Setter
    public static final class MediaTypeAttribute extends BaseAttribute {
        private MediaTypeAttrValue value;

        public MediaTypeAttribute() {
            super(EntityType.MEDIA_TYPE);
        }
    }

    @Getter
    @Setter
    public static final class SortTypeAttribute extends BaseAttribute {
        private SortTypeAttrValue value;

        public SortTypeAttribute() {
            super(EntityType.SORT_TYPE);
        }
    }

    public enum MediaTypeAttrValue {
        ALBUM,
        PLAYLIST,
        TRACK,
        STATION
    }

    public enum SortTypeAttrValue {
        RECENCY,
        POPULARITY
    }
}
