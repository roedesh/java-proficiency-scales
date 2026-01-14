package com.ruudschroen;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieRating {
    private final String source;
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public MovieRating(@JsonProperty("Source") String source, @JsonProperty("Value") String value) {
        this.source = source;
        this.value = value;
    }

    @JsonProperty("Source")
    public String getSource() {
        return source;
    }

    @JsonProperty("Value")
    public String getValue() {
        return value;
    }
}
