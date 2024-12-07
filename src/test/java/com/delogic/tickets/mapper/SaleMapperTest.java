package com.delogic.tickets.mapper;

import com.delogic.tickets.domain.Sale;
import com.delogic.tickets.dto.SaleDTO;
import com.delogic.tickets.mapper.impl.SaleMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;

public class SaleMapperTest {

    @InjectMocks
    private final SaleMapper saleMapper = new SaleMapperImpl();
    @Mock
    private ListingMapper listingMapper;
    @Mock
    private UserMapper userMapper;
    @Mock
    private EventMapper eventMapper;
    @Mock
    private DateMapper dateMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testToDTO() {
        Sale sale = new Sale();
        sale.setId(1L);
        sale.setQuantitySold(2);
        sale.setPricePaid(java.math.BigDecimal.valueOf(200.00));
        sale.setCommissionAmount(java.math.BigDecimal.valueOf(20.00));
        sale.setTimestamp(java.sql.Timestamp.valueOf("2023-10-10 20:00:00"));

        SaleDTO saleDTO = saleMapper.toDTO(sale);

        assertThat(saleDTO).isNotNull();
        assertThat(saleDTO.getId()).isEqualTo(sale.getId());
        assertThat(saleDTO.getQuantitySold()).isEqualTo(sale.getQuantitySold());
        assertThat(saleDTO.getPricePaid()).isEqualTo(sale.getPricePaid());
        assertThat(saleDTO.getCommissionAmount()).isEqualTo(sale.getCommissionAmount());
        assertThat(saleDTO.getTimestamp()).isEqualTo(sale.getTimestamp().toLocalDateTime());
    }

    @Test
    public void testToDTO_NullSale() {
        SaleDTO saleDTO = saleMapper.toDTO(null);
        assertThat(saleDTO).isNull();
    }
}