package pe.edu.cibertec.api_practica_final.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.cibertec.api_practica_final.model.dto.ArchivoDto;
import pe.edu.cibertec.api_practica_final.service.FileService;

import java.util.List;

@PreAuthorize("hasRole('GESTOR')")
@AllArgsConstructor
@RestController
@RequestMapping(path = "api/pf/files")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/filesimages")
    public ResponseEntity<ArchivoDto> subirImagenes(
            @RequestParam("images")List<MultipartFile> multipartFileList
    ) throws Exception{
        fileService.subirImagenes(multipartFileList);
        return new ResponseEntity<>(ArchivoDto.builder()
                .mensaje("Imagenes subidas correctamente").build(),
                HttpStatus.OK);
    }
}
