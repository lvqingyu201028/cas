package org.apereo.cas.support.saml.util;

import org.apereo.cas.support.saml.AbstractOpenSamlTests;

import lombok.val;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for {@link SamlCompliantUniqueTicketIdGenerator}.
 *
 * @author Scott Battaglia
 * @since 3.4.3
 */
@Tag("SAML")
@SpringBootTest(classes = AbstractOpenSamlTests.SharedTestConfiguration.class)
public class SamlCompliantUniqueTicketIdGeneratorTests extends AbstractOpenSamlTests {

    @Test
    public void verifySaml1Compliant() {
        val g = new SamlCompliantUniqueTicketIdGenerator("http://www.cnn.com");
        assertNotNull(g.getNewTicketId("TT"));
    }

    @Test
    public void verifySaml2Compliant() {
        val g = new SamlCompliantUniqueTicketIdGenerator("http://www.cnn.com");
        g.setSaml2compliant(true);
        assertNotNull(g.getNewTicketId("TT"));

    }
}
