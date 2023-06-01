package com.testproject.AllinOne.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "itemType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextItem.class, name = "Text"),

        @JsonSubTypes.Type(value = VideoItem.class, name = "Video"),
        @JsonSubTypes.Type(value = ImageItem.class, name = "Image")
}
)
public class ItemDto {

}
