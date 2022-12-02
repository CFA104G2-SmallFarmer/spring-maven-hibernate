package com.albert.management.repository;

import com.albert.management.dto.MemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemRepository extends JpaRepository<MemDTO, Long> {

    /**
     * 相当于 select *from user where name=?
     * @param name
     * @return Optional<MemDTO>
     */
    Optional<MemDTO> getByMemName(String name);

}
