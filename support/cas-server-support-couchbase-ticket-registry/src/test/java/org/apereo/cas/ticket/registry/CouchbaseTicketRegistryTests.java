package org.apereo.cas.ticket.registry;

import org.apereo.cas.config.CouchbaseTicketRegistryConfiguration;
import org.apereo.cas.util.junit.EnabledIfContinuousIntegration;

import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * This is {@link CouchbaseTicketRegistryTests}.
 *
 * @author Misagh Moayyed
 * @since 5.3.0
 */
@Tag("Couchbase")
@EnabledIfContinuousIntegration
@SpringBootTest(classes = {
    CouchbaseTicketRegistryConfiguration.class,
    BaseTicketRegistryTests.SharedTestConfiguration.class
},
    properties = {
        "cas.ticket.registry.couchbase.password=password",
        "cas.ticket.registry.couchbase.bucket=testbucket"
    })
public class CouchbaseTicketRegistryTests extends BaseTicketRegistryTests {

    @Autowired
    @Qualifier("ticketRegistry")
    private TicketRegistry ticketRegistry;

    @Override
    public TicketRegistry getNewTicketRegistry() {
        return ticketRegistry;
    }

    @Override
    protected boolean isIterableRegistry() {
        return false;
    }

}
