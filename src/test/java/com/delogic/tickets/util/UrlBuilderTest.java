package com.delogic.tickets.util;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UrlBuilderTest {

    @Test
    public void testBuildUrl_Success() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setContextPath("/api");
        request.setRequestURI("/api/dates");
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Long id = 1L;
        String expectedUrl = ServletUriComponentsBuilder.fromCurrentRequest()
                .replaceQuery(null)
                .path("/{id}")
                .buildAndExpand(id)
                .toUriString();

        String result = UrlBuilder.buildUrl(id);

        assertEquals(expectedUrl, result);
        RequestContextHolder.resetRequestAttributes();
    }
}