package pe.edu.cibertec.api_practica_final.service;

import pe.edu.cibertec.api_practica_final.model.bd.Autor;

import java.util.List;
import java.util.Optional;

public interface IAutorService {
    List<Autor> listarAutores();
    Autor guardarAutor(Autor autor);
    Optional<Autor> obtenerAutorxId(Integer id);
}
