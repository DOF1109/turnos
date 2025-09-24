package com.example.turnos.repository;

import com.example.turnos.model.Paciente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pacienteClient", url = "http://localhost:9001")
public interface IPacienteClient {

    @GetMapping("pacientes/dni/{dni}")
    public Paciente getPacienteByDni(@PathVariable String dni);
}
