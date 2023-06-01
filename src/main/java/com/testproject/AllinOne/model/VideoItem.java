package com.testproject.AllinOne.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.net.URL;


public class VideoItem extends ItemDto{

    @NotBlank
    @JsonProperty("url")
    private URL url;
    public VideoItem(@JsonProperty("url") URL url){
        this.url = url;
    }
}