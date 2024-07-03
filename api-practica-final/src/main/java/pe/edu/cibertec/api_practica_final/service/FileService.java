package pe.edu.cibertec.api_practica_final.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileService implements IFileService {

    private final Path pathFolder = Paths.get("images");

    @Override
    public void subirImagen(MultipartFile imagen) throws Exception {
        Files.copy(imagen.getInputStream(),
                this.pathFolder.resolve(imagen.getOriginalFilename()));
    }

    @Override
    public void subirImagenes(List<MultipartFile> imagenList) throws Exception {
        for (MultipartFile imagen : imagenList) {
            this.subirImagen(imagen);
        }
    }
}
