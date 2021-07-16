package com.example.cardserver;

import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cards")
public class CardController {
    private final MongoTemplate mongoTemplate;

    public CardController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @GetMapping("/list")
    public List<CardData> listCards() {
        return mongoTemplate.findAll(CardDataEntity.class)
                .stream()
                .map(CardDataEntity::toDto)
                .collect(Collectors.toList());

    }

    @PostMapping("")
    public CardData create(@RequestBody CardData cardData) {
        if (cardData == null) {
            return null;
        }
        return CardDataEntity.toDto(mongoTemplate.save(CardDataEntity.toEntity(cardData)));
    }

    @PutMapping("")
    public CardData update(@RequestBody CardData cardData) {
        if (cardData == null) {
            return null;
        }
        return CardDataEntity.toDto(mongoTemplate.save(CardDataEntity.toEntity(cardData)));
    }

    @DeleteMapping("")
    public boolean delete(@RequestBody CardData cardData) {
        if (cardData == null) {
            return false;
        }
        mongoTemplate.remove(CardDataEntity.toEntity(cardData));
        return true;
    }
}

