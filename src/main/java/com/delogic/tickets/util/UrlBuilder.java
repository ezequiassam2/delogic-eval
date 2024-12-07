package com.delogic.tickets.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class UrlBuilder {

    public static String buildUrl(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .replaceQuery(null)
                .path("/{id}")
                .buildAndExpand(id)
                .toUriString();
    }
}