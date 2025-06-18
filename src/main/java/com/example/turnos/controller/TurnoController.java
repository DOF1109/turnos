package com.example.turnos.controller;

import com.example.turnos.model.Turno;
import com.example.turnos.service.ITurnoService;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private ITurnoService turnoService;

    @GetMapping
    public List<Turno> getAllTurnos() {
        return turnoService.getAllTurnos();
    }

    @PostMapping
    public Turno createTurno(@RequestBody Turno turno) {
        return turnoService.createTurno(turno);
    }

    @GetMapping("/{id}")
    public Turno getTurnoById(@PathVariable Long id) {
        return turnoService.getTurnoById(id);
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
