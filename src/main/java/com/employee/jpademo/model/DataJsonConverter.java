package com.employee.jpademo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DataJsonConverter {
    @JsonProperty("translations")
    private List<JsonConverter> jsonConverters;
}
