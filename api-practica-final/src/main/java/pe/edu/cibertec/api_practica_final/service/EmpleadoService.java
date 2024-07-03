package pe.edu.cibertec.api_practica_final.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.api_practica_final.model.bd.Empleado;
import pe.edu.cibertec.api_practica_final.repository.EmpleadoRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class EmpleadoService implements IEmpleadoService {
    private EmpleadoRepository empleadoRepository;
    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }
}
