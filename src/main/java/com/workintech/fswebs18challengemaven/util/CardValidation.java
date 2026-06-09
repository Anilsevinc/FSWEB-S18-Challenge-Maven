package com.workintech.fswebs18challengemaven.util;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Type;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import org.springframework.http.HttpStatus;

public class CardValidation {

    private CardValidation() {
    }

    public static void validate(Card card) {
        if (card.getValue() != null && card.getType() != null) {
            throw new CardException("A card cannot have both value and type", HttpStatus.BAD_REQUEST);
        }

        if (card.getType() == Type.JOKER) {
            if (card.getValue() != null || card.getColor() != null) {
                throw new CardException("Joker card cannot have value or color", HttpStatus.BAD_REQUEST);
            }
        }
    }
}
