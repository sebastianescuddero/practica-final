package pe.edu.cibertec.api_practica_final.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idempleado")
    private Integer idempleado;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "fechacontrat")
    private Date fechacontrat;
    @ManyToOne
    @JoinColumn(name = "iddomicilio")
    private Domicilio domicilio;
}
