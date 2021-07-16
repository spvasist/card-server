package com.example.cardserver;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class CardData {
    private String id;
    private String image;
    private String title;
    private String body;
    private String userId;
    private long timestamp;

}
