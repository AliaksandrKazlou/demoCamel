package com.epam.demo.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.impl.DefaultExchangeHolder;

import java.util.ArrayList;
import java.util.List;
/*
 * Класс, реализующий первую часть шаблона EnvelopeWrapper
 * By default Exchange не сериализуемый объект
 * В этом классе все из списка Exchange оборачиваются в DefaultExchangeHolder, который сериализует Exchange.
 * Всё что не сериализует DefaultExchangeHolder  - запишется в лог(см. документацию по DefaultExchange Holder)
 */
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
