package pe.edu.cibertec.api_practica_final.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.api_practica_final.model.dto.DtoEntity;
import pe.edu.cibertec.api_practica_final.model.dto.PublicacionDto;
import pe.edu.cibertec.api_practica_final.service.IPublicacionService;
import pe.edu.cibertec.api_practica_final.util.DtoUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@PreAuthorize("hasRole('COORDINADOR')")
@AllArgsConstructor
@RestController
@RequestMapping(path = "api/pf/publicacion")
public class PublicacionController {

    private IPublicacionService iPublicacionService;

    @GetMapping("/pubs-dto")
    public ResponseEntity<List<DtoEntity>> listarPublicacionesDto(){
        List<DtoEntity> publicacionDtoList = new ArrayList<>();
        publicacionDtoList = iPublicacionService.listarPublicaciones()
                .stream()
                .map(x -> new DtoUtil().convertirADto(x, new PublicacionDto()))
                .collect(Collectors.toList());
        if(publicacionDtoList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(publicacionDtoList, HttpStatus.OK);
    }
}
