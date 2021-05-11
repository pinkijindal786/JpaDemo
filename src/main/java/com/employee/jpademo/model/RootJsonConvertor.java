package com.employee.jpademo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RootJsonConvertor {
    @JsonProperty("data")
    private DataJsonConverter dataJsonConverter;

}
