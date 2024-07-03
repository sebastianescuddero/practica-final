package pe.edu.cibertec.api_practica_final.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.api_practica_final.model.bd.Domicilio;
import pe.edu.cibertec.api_practica_final.repository.DomicilioRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DomicilioService implements IDomicilioService{
    private DomicilioRepository domicilioRepository;
    @Override
    public List<Domicilio> listarDomicilios() {
        return domicilioRepository.findAll();
    }

    @Override
    public Domicilio guardarDomicilio(Domicilio domicilio) {
        return domicilioRepository.save(domicilio);
    }

    @Override
    public Optional<Domicilio> obtenerDomicilioxId(Integer id) {
        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        if (domicilio.isEmpty()){
            return Optional.empty();
        }
        return domicilio;
    }
}
