package com.java.aula03.repositories;

import com.java.aula03.entities.Militar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MilitarRepository extends JpaRepository<Militar,Long> {


}
