package pe.edu.cibertec.api_practica_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.api_practica_final.model.bd.Domicilio;

@Repository
public interface DomicilioRepository
        extends JpaRepository<Domicilio, Integer> {
}
