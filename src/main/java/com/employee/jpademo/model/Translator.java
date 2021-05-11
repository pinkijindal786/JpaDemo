package com.employee.jpademo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Translator {
    @JsonProperty("q")
    private String body;
    private String source;
    private String target;

    @Override
    public String toString() {
        String arr = body.replaceAll(" ", "%2C%20");
        return "q=" + arr + "&source=" + source + "&target=" + target;
    }
}
