package com.mayanna.awssqscloud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private Integer id;
    private String movietitle;
    private String streamingPlatform;
    private String language;

}
