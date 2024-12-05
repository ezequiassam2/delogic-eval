package com.delogic.tickets.repository;

import com.delogic.tickets.domain.Sale;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class SaleRepositoryTest {

    @Autowired
    private SaleRepository saleRepository;

    @Test
    public void testSaveAndFindSale() {
        Sale sale = new Sale();
        sale.setCommissionAmount(BigDecimal.valueOf(100.0));
        saleRepository.save(sale);

        Optional<Sale> foundSale = saleRepository.findById(sale.getId());
        assertThat(foundSale).isPresent();
        assertThat(foundSale.get().getCommissionAmount()).isEqualTo(sale.getCommissionAmount());
    }
}