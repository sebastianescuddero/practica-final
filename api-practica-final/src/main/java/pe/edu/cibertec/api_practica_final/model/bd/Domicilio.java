package pe.edu.cibertec.api_practica_final.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Domicilio")
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddomicilio")
    private Integer iddomicilio;
    @Column(name = "descdomicilio")
    private String descdomicilio;
    @Column(name = "nrodomicilio")
    private Integer nrodomicilio;
    @Column(name = "refdomicilio")
    private String refdomicilio;
}
