package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional(readOnly = true)
public interface BenutzerRepository extends JpaRepository<Benutzer, UUID> {
    Optional<Benutzer> findBenutzerByUsername(String username);

}
