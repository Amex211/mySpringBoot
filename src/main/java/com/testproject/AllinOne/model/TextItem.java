package com.testproject.AllinOne.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;


public class TextItem extends ItemDto{
    @NotBlank
    @JsonProperty("content")
    private String Content;

    public TextItem(@JsonProperty("content") String Content){
        this.Content = Content;
    }


}
