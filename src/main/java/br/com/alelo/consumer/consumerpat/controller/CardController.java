package br.com.alelo.consumer.consumerpat.controller;

import br.com.alelo.consumer.consumerpat.domain.Card;
import br.com.alelo.consumer.consumerpat.request.CardRequest;
import br.com.alelo.consumer.consumerpat.request.ConsumerRequest;
import br.com.alelo.consumer.consumerpat.response.CardResponse;
import br.com.alelo.consumer.consumerpat.response.ConsumerResponse;
import br.com.alelo.consumer.consumerpat.service.CardService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/card", produces = MediaType.APPLICATION_JSON_VALUE)
public class CardController {

    @Autowired
    private CardService cardService;

    @ApiOperation(value = "Creates a new card", notes = "Creates a new card for consumer", httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code = 201, message = "New create card successfully", response = CardResponse.class),
            @ApiResponse(code = 422, message = "Consumer not found /" +
                                               "This card is not accepted at this establishment")
    })
    @PostMapping
    public ResponseEntity<CardResponse> createCardForConsumer(@Validated @RequestBody CardRequest cardRequest) {
        return new ResponseEntity<>(cardService.createCardForConsumer(cardRequest), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Creates a new card", notes = "Creates a new card for consumer", httpMethod = "PATCH")
    @ApiResponses({
            @ApiResponse(code = 201, message = "New create card successfully", response = CardResponse.class),
            @ApiResponse(code = 404, message = "Card not found"),
            @ApiResponse(code = 422, message = "The card informed is not active")
    })
    @PatchMapping("/{cardNumber}/addBalance")
    public ResponseEntity<CardResponse> addBalanceForCard(@PathVariable("cardNumber") String cardNumber, BigDecimal cardBalance){
        return new ResponseEntity<>(cardService.addBalanceForCard(cardNumber, cardBalance), HttpStatus.OK);
    }
}
