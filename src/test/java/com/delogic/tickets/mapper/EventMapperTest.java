package com.delogic.tickets.mapper;

import com.delogic.tickets.domain.Event;
import com.delogic.tickets.dto.EventDTO;
import com.delogic.tickets.mapper.impl.EventMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;

public class EventMapperTest {

    @InjectMocks
    private final EventMapper eventMapper = new EventMapperImpl();
    @Mock
    private CategoryMapper categoryMapper;
    @Mock
    private VenueMapper venueMapper;
    @Mock
    private DateMapper dateMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testToDTO() {
        Event event = new Event();
        event.setId(1L);
        event.setName("Rock Concert");
        event.setStartTime(java.sql.Timestamp.valueOf("2023-10-10 20:00:00"));

        EventDTO eventDTO = eventMapper.toDTO(event);

        assertThat(eventDTO).isNotNull();
        assertThat(eventDTO.getId()).isEqualTo(event.getId());
        assertThat(eventDTO.getName()).isEqualTo(event.getName());
        assertThat(eventDTO.getStartTime()).isEqualTo(event.getStartTime().toLocalDateTime());
    }

    @Test
    public void testToDTO_NullEvent() {
        EventDTO eventDTO = eventMapper.toDTO(null);
        assertThat(eventDTO).isNull();
    }
}