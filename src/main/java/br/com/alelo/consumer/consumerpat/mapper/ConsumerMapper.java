package br.com.alelo.consumer.consumerpat.mapper;

import br.com.alelo.consumer.consumerpat.domain.Card;
import br.com.alelo.consumer.consumerpat.domain.Consumer;
import br.com.alelo.consumer.consumerpat.request.ConsumerRequest;
import br.com.alelo.consumer.consumerpat.response.CardResponse;
import br.com.alelo.consumer.consumerpat.response.ConsumerForCardsResponse;
import br.com.alelo.consumer.consumerpat.response.ConsumerResponse;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Component
public class ConsumerMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Consumer toEntity(ConsumerRequest consumerRequest) {
        return modelMapper.map(consumerRequest, Consumer.class);
    }

    public ConsumerResponse toResponse(Consumer consumer) {
        return modelMapper.map(consumer, ConsumerResponse.class);
    }
}

