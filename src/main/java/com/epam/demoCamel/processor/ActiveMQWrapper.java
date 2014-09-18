package com.epam.demoCamel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.impl.DefaultExchangeHolder;

import java.util.ArrayList;
import java.util.List;

public class ActiveMQWrapper implements Processor {

    @Override
    public void process (Exchange exchange) throws Exception {
        List<Exchange> exchanges = exchange.getIn().getBody(List.class);
        List<DefaultExchangeHolder> holders = new ArrayList<>();
        for (Exchange ex : exchanges) {
            holders.add(DefaultExchangeHolder.marshal(ex));
        }
        exchange.getIn().setBody(holders);
    }
}
