package pe.edu.cibertec.api_practica_final.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.api_practica_final.model.bd.Publicacion;
import pe.edu.cibertec.api_practica_final.repository.PublicacionRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class PublicacionService implements IPublicacionService {
    private PublicacionRepository publicacionRepository;
    @Override
    public List<Publicacion> listarPublicaciones() {
        return publicacionRepository.findAll();
    }
}
