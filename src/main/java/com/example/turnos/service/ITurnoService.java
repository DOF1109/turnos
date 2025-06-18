package com.example.turnos.service;

import com.example.turnos.model.Turno;

import java.time.LocalDate;
import java.util.List;

public interface ITurnoService {
    void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente);
    void updateTurno(Long id, Turno turno);
    void deleteTurno(Long id);
    Turno findTurnoById(Long id);
    List<Turno> findAllTurnos();
}
