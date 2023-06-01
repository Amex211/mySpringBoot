package com.testproject.AllinOne.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import java.util.ArrayList;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    @JsonProperty("id")
    private UUID id = UUID.randomUUID();
    @NotBlank
    @JsonProperty("versionID")
    private Integer versionID;
    @NotBlank
    @JsonProperty("name")
    private String name;
    @NotBlank
    @JsonProperty("items")
    private ArrayList<ItemDto> items;


}
