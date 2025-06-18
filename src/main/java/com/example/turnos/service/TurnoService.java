package com.example.turnos.service;

import com.example.turnos.model.Turno;
import com.example.turnos.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class TurnoService implements ITurnoService {
    @Autowired
    private ITurnoRepository turnoRepository;

    @Override
    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente) {
        // Paciente paciente = buscar en la api de pacientes
        // String NombreCompletoPaciente = paciente.getNombte() + " " + paciente.getApellido();

        Turno turno = new Turno();
        turno.setFecha(fecha);
        turno.setTratamiento(tratamiento);
        turno.setNombreCompletoPaciente("Nombre completo del paciente");

        turnoRepository.save(turno);
    }

    @Override
    public void updateTurno(Long id, Turno turno) {
        Turno turnoBD = this.findTurnoById(id);
        turnoBD.setFecha(turno.getFecha());
        turnoBD.setTratamiento(turno.getTratamiento());
        turnoBD.setNombreCompletoPaciente(turno.getNombreCompletoPaciente());

        turnoRepository.save(turnoBD);
    }

    @Override
    public void deleteTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Turno findTurnoById(Long id) {
        return turnoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Turno> findAllTurnos() {
        return turnoRepository.findAll();
    }
}
