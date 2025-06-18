package com.example.turnos.controller;

import com.example.turnos.model.Turno;
import com.example.turnos.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private ITurnoService turnoService;

    @GetMapping
    public List<Turno> getAllTurnos() {
        return turnoService.findAllTurnos();
    }

    @PostMapping
    public void createTurno(@RequestBody LocalDate fecha,
                            @RequestParam String tratamiento,
                            @RequestParam String dniPaciente) {
        turnoService.saveTurno(fecha, tratamiento, dniPaciente);
    }

    @GetMapping("/{id}")
    public Turno getTurnoById(@PathVariable Long id) {
        return turnoService.findTurnoById(id);
    }

    @PutMapping("/{id}")
    public void updateTurno(@PathVariable Long id, @RequestBody Turno turno) {
        turnoService.updateTurno(id, turno);
    }

    @DeleteMapping("/{id}")
    public void deleteTurno(@PathVariable Long id) {
        turnoService.deleteTurno(id);
    }
}
