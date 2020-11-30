package edu.nit.librarymanage.controller;

import edu.nit.librarymanage.persist.FileEntity;
import edu.nit.librarymanage.persist.FileRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RequestMapping("file")
@RestController
public class FileController {

    private final FileRepository fileRepository;

    public FileController(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @PostMapping
    public Long upload(
            @RequestParam("file") MultipartFile file
    ) throws IOException {

            String s = Base64.getEncoder().encodeToString(file.getBytes());
            FileEntity f = new FileEntity();
            f.setContent(s);
            f.setName(file.getName());
            f.setContentType(file.getContentType());
            FileEntity save = fileRepository.save(f);
            return save.getId();

    }



}
