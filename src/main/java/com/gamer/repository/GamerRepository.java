package com.gamer.repository;

import com.gamer.model.dto.GamerDTO;
import com.gamer.model.entity.Gamer;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface GamerRepository extends JpaRepository<Gamer, Long>, JpaSpecificationExecutor<Gamer> {
    Optional<Gamer> findByName(String name);

    @Query("select g.id FROM Gamer g WHERE g.name = :name")
    Optional<Long> findIdByName(@Param("name") String name);
}
