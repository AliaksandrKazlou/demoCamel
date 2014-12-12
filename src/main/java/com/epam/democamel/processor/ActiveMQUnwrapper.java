package com.epam.democamel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.impl.DefaultExchangeHolder;

import java.util.ArrayList;
import java.util.List;

public class ActiveMQUnwrapper implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        List<DefaultExchangeHolder> holders = exchange.getIn().getBody(List.class);
        List<DefaultExchange> exchanges = new ArrayList<>();
        DefaultExchange ex = new DefaultExchange(exchange);
        for (DefaultExchangeHolder holder : holders) {
            DefaultExchangeHolder.unmarshal(ex, holder);
            exchanges.add(ex);
        }
        exchange.getIn().setBody(exchanges);
    }
}
