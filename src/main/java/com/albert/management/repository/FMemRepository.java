package com.albert.management.repository;

import com.albert.management.dto.FMemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FMemRepository extends JpaRepository<FMemDTO, Long> {

    /**
     * 相当于 select *from user where name=?
     * @param name
     * @return Optional<FMemDTO>
     */
    Optional<FMemDTO> getByfMemFname(String name);
//    Optional<FMemDTO> getByFMemFname(String name); 不能這樣寫

}
