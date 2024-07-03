package pe.edu.cibertec.api_practica_final.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.api_practica_final.exception.ResourceNotFoundException;
import pe.edu.cibertec.api_practica_final.model.bd.Domicilio;
import pe.edu.cibertec.api_practica_final.service.DomicilioService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/pf/domicilio")
public class DomicilioController {
    private DomicilioService domicilioService;

    @GetMapping("")
    public ResponseEntity<List<Domicilio>> listarDomicilios(){
        List<Domicilio> categoryList = new ArrayList<>(domicilioService.listarDomicilios());
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Domicilio> obtenerDomicilioXId(
            @PathVariable Integer id){
        Domicilio domicilio = domicilioService
                .obtenerDomicilioxId(id).orElseThrow(
                        () -> new ResourceNotFoundException("El domicilio con Id " +
                                id + " no existe"));
        return new ResponseEntity<>(domicilio, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Domicilio> registrarDomicilio(
            @RequestBody Domicilio category
    ){
        return new ResponseEntity<>(
                domicilioService.guardarDomicilio(category), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Domicilio> actualizarDomicilio(
            @PathVariable Integer id,
            @RequestBody Domicilio domicilio
    ){
        Domicilio newDomicilio = domicilioService.obtenerDomicilioxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El domicilio con Id "
                        + id +" no existe"));
        newDomicilio.setDescdomicilio(domicilio.getDescdomicilio());
        newDomicilio.setNrodomicilio(domicilio.getNrodomicilio());
        newDomicilio.setRefdomicilio(domicilio.getRefdomicilio());
        return new ResponseEntity<>(
                domicilioService.guardarDomicilio(newDomicilio),
                HttpStatus.OK);
    }
}
