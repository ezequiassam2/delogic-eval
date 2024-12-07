package com.delogic.tickets.config;

import com.delogic.tickets.mapper.*;
import com.delogic.tickets.mapper.impl.*;
import com.delogic.tickets.repository.*;
import com.delogic.tickets.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TicketsConfig {

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }

    @Bean
    public UserService userService(UserRepository userRepository, UserMapper userMapper) {
        return new UserService(userRepository, userMapper);
    }

    @Bean
    public EventMapper eventMapper() {
        return new EventMapperImpl();
    }

    @Bean
    public EventService eventService(EventRepository eventRepository, EventMapper eventMapper) {
        return new EventService(eventRepository, eventMapper);
    }

    @Bean
    public VenueMapper venueMapper() {
        return new VenueMapperImpl();
    }

    @Bean
    public VenueService venueService(VenueRepository venueRepository, VenueMapper venueMapper) {
        return new VenueService(venueRepository, venueMapper);
    }

    @Bean
    public CategoryMapper categoryMapper() {
        return new CategoryMapperImpl();
    }

    @Bean
    public CategoryService categoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        return new CategoryService(categoryRepository, categoryMapper);
    }

    @Bean
    public DateMapper dateMapper() {
        return new DateMapperImpl();
    }

    @Bean
    public DateService dateService(DateRepository dateRepository, DateMapper dateMapper) {
        return new DateService(dateRepository, dateMapper);
    }

    @Bean
    public ListingMapper listingMapper() {
        return new ListingMapperImpl();
    }

    @Bean
    public ListingService listingService(ListingRepository listingRepository, ListingMapper listingMapper) {
        return new ListingService(listingRepository, listingMapper);
    }

    @Bean
    public SaleMapper saleMapper() {
        return new SaleMapperImpl();
    }

    @Bean
    public SaleService saleService(SaleRepository saleRepository, SaleMapper saleMapper) {
        return new SaleService(saleRepository, saleMapper);
    }
}