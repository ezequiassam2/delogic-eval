package com.delogic.tickets.controller;

import com.delogic.tickets.dto.SaleDTO;
import com.delogic.tickets.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaleController extends BaseController {

    @Autowired
    private SaleService saleService;

    @GetMapping("/sales")
    public ResponseEntity<List<?>> getAllSaleIds(@RequestParam(defaultValue = "${default.page}") int page, @RequestParam(defaultValue = "${default.size}") int size, @RequestParam(defaultValue = "false") boolean includeUrls) {
        List<?> sales = saleService.getAllIdsOrUrls(page, size, includeUrls);
        return ResponseEntity.ok(sales);
    }

    @GetMapping("/sales/{id}")
    public ResponseEntity<SaleDTO> getSaleById(@PathVariable Long id) {
        return saleService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}