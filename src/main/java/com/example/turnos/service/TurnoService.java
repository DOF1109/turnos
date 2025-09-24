package com.example.turnos.service;

import com.example.turnos.model.Paciente;
import com.example.turnos.model.Turno;
import com.example.turnos.repository.IPacienteClient;
import com.example.turnos.repository.ITurnoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    private IPacienteClient pacienteClient;

    @Override
    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente) {
        try {
            // Busca en la api de pacientes
            Paciente paciente = pacienteClient.getPacienteByDni(dniPaciente);

            if (paciente == null) {
                throw new RuntimeException("No se encontró el paciente con DNI: " + dniPaciente);
            }

            log.info("Paciente encontrado: {} {}", paciente.getNombre(), paciente.getApellido());

            String nombreCompletoPaciente = paciente.getNombre() + " " + paciente.getApellido();

            Turno turno = new Turno();
            turno.setFecha(fecha);
            turno.setTratamiento(tratamiento);
            turno.setNombreCompletoPaciente(nombreCompletoPaciente);

            turnoRepository.save(turno);
            log.info("Turno guardado exitosamente");
        } catch (Exception e) {
            log.error("Error al guardar el turno: {}", e.getMessage());
            throw new RuntimeException("Error al procesar el turno: " + e.getMessage());
        }
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
