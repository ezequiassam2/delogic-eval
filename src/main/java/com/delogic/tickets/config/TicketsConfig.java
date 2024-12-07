package com.delogic.tickets.config;

import com.delogic.tickets.mapper.*;
import com.delogic.tickets.mapper.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TicketsConfig {

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }

    @Bean
    public EventMapper eventMapper() {
        return new EventMapperImpl();
    }

    @Bean
    public VenueMapper venueMapper() {
        return new VenueMapperImpl();
    }

    @Bean
    public CategoryMapper categoryMapper() {
        return new CategoryMapperImpl();
    }

    @Bean
    public DateMapper dateMapper() {
        return new DateMapperImpl();
    }

    @Bean
    public ListingMapper listingMapper() {
        return new ListingMapperImpl();
    }

    @Bean
    public SaleMapper saleMapper() {
        return new SaleMapperImpl();
    }
}