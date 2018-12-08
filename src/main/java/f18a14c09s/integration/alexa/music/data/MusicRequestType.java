package f18a14c09s.integration.alexa.music.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import f18a14c09s.integration.json.JSONAdapter;

import java.util.*;

public class MusicRequestType {
    private String namespace;
    private String name;

    public MusicRequestType() {
    }

    public MusicRequestType(String namespace, String name) {
        if (namespace == null || name == null) {
            throw new NullPointerException("namespace and name are required.");
        }
        this.namespace = namespace;
        this.name = name;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object rhsO) {
        MusicRequestType rhs = rhsO instanceof MusicRequestType ? (MusicRequestType) rhsO : null;
        return getNamespace() != null && getName() != null && rhs != null &&
                Objects.equals(rhs.getNamespace(), getNamespace()) && Objects.equals(rhs.getName(), getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNamespace(), getName());
    }

    @Override
    public String toString() {
        try {
            return new JSONAdapter().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return super.toString();
        }
    }
}
