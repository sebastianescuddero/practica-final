package pe.edu.cibertec.api_practica_final.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.api_practica_final.exception.ResourceNotFoundException;
import pe.edu.cibertec.api_practica_final.model.bd.Autor;
import pe.edu.cibertec.api_practica_final.service.AutorService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/pf/autor")
public class AutorController {
    private AutorService autorService;

    @GetMapping("")
    public ResponseEntity<List<Autor>> listarAutores(){
        List<Autor> autorList = new ArrayList<>(autorService.listarAutores());
        if(autorList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(autorList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> obtenerAutorXId(
            @PathVariable Integer id){
        Autor category = autorService
                .obtenerAutorxId(id).orElseThrow(
                        () -> new ResourceNotFoundException("El autor con Id " +
                                id + " no existe"));
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Autor> registrarAutor(
            @RequestBody Autor category
    ){
        return new ResponseEntity<>(
                autorService.guardarAutor(category), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> actualizarAutor(
            @PathVariable Integer id,
            @RequestBody Autor autor
    ){
        Autor newAutor = autorService.obtenerAutorxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El autor con Id "
                        + id +" no existe"));
        newAutor.setNomautor(autor.getNomautor());
        newAutor.setApeautor(autor.getApeautor());
        newAutor.setFechnacautor(autor.getFechnacautor());
        return new ResponseEntity<>(
                autorService.guardarAutor(newAutor),
                HttpStatus.OK);
    }
}
