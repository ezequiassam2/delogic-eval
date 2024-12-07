package com.delogic.tickets.service;

import com.delogic.tickets.repository.BaseRepository;
import com.delogic.tickets.util.UrlBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class BaseService<T, D> {

    protected final BaseRepository<T, Long> repository;

    protected BaseService(BaseRepository<T, Long> repository) {
        this.repository = repository;
    }

    public List<?> getAllIdsOrUrls(int page, int size, boolean includeUrls) {
        if (includeUrls) {
            return getAllIdsUrls(page, size);
        } else {
            return getAllIds(page, size);
        }
    }

    protected List<Long> getAllIds(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Long> idsPage = repository.findAllIds(pageable);
        return idsPage.getContent();
    }

    protected List<String> getAllIdsUrls(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Long> idsPage = repository.findAllIds(pageable);
        return idsPage.getContent().stream()
                .map(id -> UrlBuilder.buildUrl(id))
                .collect(Collectors.toList());
    }

    public Optional<D> getById(Long id) {
        return repository.findById(id).map(this::toDTO);
    }

    protected abstract D toDTO(T entity);
}