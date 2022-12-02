package com.albert.management.service;

import com.albert.management.dto.MemDTO;
import com.albert.management.repository.MemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemService {

    private final MemRepository memRepository;

    public MemService(MemRepository memRepository) {
        this.memRepository = memRepository;
    }
    
    public MemDTO save(MemDTO mem) {
        return memRepository.save(mem);
    }

    public void delete(MemDTO memDTO) {
        memRepository.delete(memDTO);
    }

    public Optional<MemDTO> findById(Long id) {
        return memRepository.findById(id);
    }

    public Page<MemDTO> findAllByPageable(Pageable pageable) {
        return memRepository.findAll(pageable);
    }

}
