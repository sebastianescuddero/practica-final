package pe.edu.cibertec.api_practica_final.service;

import pe.edu.cibertec.api_practica_final.model.bd.Domicilio;

import java.util.List;
import java.util.Optional;

public interface IDomicilioService {
    List<Domicilio> listarDomicilios();
    Domicilio guardarDomicilio(Domicilio domicilio);
    Optional<Domicilio> obtenerDomicilioxId(Integer id);
}
