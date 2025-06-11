package com.example.turnos.repository;

import com.example.turnos.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnoRepository extends JpaRepository<Turno, Long> {
}
