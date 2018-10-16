package com.micro.service.forex.forexservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexController {

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue
            (@PathVariable String from, @PathVariable String to) {
        ExchangeValue exchangeValue =exchangeValueRepository.findByFromAndTo(from, to);
        ExchangeValue fromValue = exchangeValueRepository.findByFrom(from);
        exchangeValue.setPort(
                Integer.parseInt(environment.getProperty("local.server.port")));
        return exchangeValue;
    }

}
