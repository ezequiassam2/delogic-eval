package com.delogic.tickets.repository;

import com.delogic.tickets.domain.Sale;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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

    @Test
    public void testFindAllIds() {
        Sale sale1 = new Sale();
        sale1.setCommissionAmount(BigDecimal.valueOf(100.0));
        saleRepository.save(sale1);

        Sale sale2 = new Sale();
        sale2.setCommissionAmount(BigDecimal.valueOf(200.0));
        saleRepository.save(sale2);

        Pageable pageable = PageRequest.of(0, 10);
        Page<Long> idsPage = saleRepository.findAllIds(pageable);

        assertThat(idsPage).isNotNull();
        assertThat(idsPage.getContent()).containsExactlyInAnyOrder(sale1.getId(), sale2.getId());
    }
}