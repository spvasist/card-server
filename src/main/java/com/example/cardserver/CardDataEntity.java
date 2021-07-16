package com.example.cardserver;

import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "card")
public class CardDataEntity {
    @Id
    private String id;
    private String image;
    private String title;
    private String body;
    private String userId;
    private long timestamp;

    public static CardData toDto(CardDataEntity cardDataEntity) {
        if (cardDataEntity == null) {
            return null;
        }
        CardData cardData = new CardData();
        BeanUtils.copyProperties(cardDataEntity, cardData);
        return cardData;
    }

    public static CardDataEntity toEntity(CardData cardData) {
        if (cardData == null) {
            return null;
        }
        CardDataEntity cardDataEntity = new CardDataEntity();
        BeanUtils.copyProperties(cardData, cardDataEntity);
        return cardDataEntity;
    }
}


