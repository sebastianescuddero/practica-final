package pe.edu.cibertec.api_practica_final.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.api_practica_final.model.bd.Empleado;
import pe.edu.cibertec.api_practica_final.service.EmpleadoService;

import java.util.ArrayList;
import java.util.List;

@PreAuthorize("hasRole('ADMIN')")
@AllArgsConstructor
@RestController
@RequestMapping("api/pf/empleado")
public class EmpleadoController {
    private EmpleadoService empleadoService;

    @GetMapping("")
    public ResponseEntity<List<Empleado>> listarEmpleados(){
        List<Empleado> empleadoList = new ArrayList<>(empleadoService.listarEmpleados());
        if(empleadoList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(empleadoList, HttpStatus.OK);
    }
}
