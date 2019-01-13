package f18a14c09s.integration.alexa.music.catalog.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import f18a14c09s.integration.alexa.music.entities.Station;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

import static f18a14c09s.integration.alexa.music.catalog.data.CatalogTypeName.AMAZON_BROADCAST_CHANNEL;
import static f18a14c09s.integration.alexa.music.catalog.data.CatalogTypeName.AMAZON_MUSIC_ALBUM;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@DiscriminatorValue(AMAZON_BROADCAST_CHANNEL)
public class BroadcastChannelCatalog extends AbstractCatalog {
    @ManyToMany
    @JoinTable(name = "catalog_stations", joinColumns = {
            @JoinColumn(name = "catalog_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "station_id", referencedColumnName = "id")})
    private List<Station> entities;

    public BroadcastChannelCatalog() {
        super(null, null);
    }

    @Override
    public String getDefaultUsage() {
        return "AlexaMusic.Catalog.BroadcastChannel";
    }
}