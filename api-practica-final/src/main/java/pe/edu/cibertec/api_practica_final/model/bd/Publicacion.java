package pe.edu.cibertec.api_practica_final.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Publicacion")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpublicacion")
    private Integer idpublicacion;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "resumen")
    private String resumen;
    @Column(name = "fechpublicacion")
    private Date fechpublicacion;
    @ManyToOne
    @JoinColumn(name = "idautor")
    private Autor autor;
}
