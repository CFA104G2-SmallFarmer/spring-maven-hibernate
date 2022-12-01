package com.albert.management.repository;

import com.albert.management.dto.MemberDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberDTO, Long> {

    /**
     * 相当于 select *from user where name=?
     * @param name
     * @return Optional<MemberDTO>
     */
    Optional<MemberDTO> findByNameIs(String name);
}
