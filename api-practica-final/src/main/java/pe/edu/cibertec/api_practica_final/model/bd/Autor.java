package pe.edu.cibertec.api_practica_final.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idautor")
    private Integer idautor;
    @Column(name = "nomautor")
    private String nomautor;
    @Column(name = "apeautor")
    private String apeautor;
    @Column(name = "fechnacautor")
    private Date fechnacautor;
}
