package pe.edu.cibertec.api_practica_final.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IFileService {
    void subirImagen(MultipartFile imagen) throws Exception;
    void subirImagenes(List<MultipartFile> imagenList) throws Exception;
}
