package com.example.turnos.service;

import com.example.turnos.model.Turno;

import java.util.List;

public interface ITurnoService {
    void createTurno(Turno turno);
    void updateTurno(Long id, Turno turno);
    void deleteTurno(Long id);
    Turno getTurnoById(Long id);
    List<Turno> getAllTurnos();
}
