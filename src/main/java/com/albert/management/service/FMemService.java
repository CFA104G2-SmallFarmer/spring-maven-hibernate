package com.albert.management.service;

import com.albert.management.dto.FMemDTO;
import com.albert.management.repository.FMemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FMemService {

    private final FMemRepository fMemRepository;

    public FMemService(FMemRepository fMemRepository) {
        this.fMemRepository = fMemRepository;
    }
    
    public FMemDTO save(FMemDTO mem) {
        return fMemRepository.save(mem);
    }

    public void delete(FMemDTO fMemDTO) {
        fMemRepository.delete(fMemDTO);
    }

    public Optional<FMemDTO> findById(Long id) {
        return fMemRepository.findById(id);
    }

    public Page<FMemDTO> findAllByPageable(Pageable pageable) {
        return fMemRepository.findAll(pageable);
    }

}
