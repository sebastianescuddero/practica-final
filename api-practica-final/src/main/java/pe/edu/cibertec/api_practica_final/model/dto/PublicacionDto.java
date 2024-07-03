package pe.edu.cibertec.api_practica_final.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PublicacionDto implements DtoEntity {
    private String titulo;
    private String resumen;
    private Date fechpublicacion;
    private String autorNomautor;
    private String autorApeautor;
}
