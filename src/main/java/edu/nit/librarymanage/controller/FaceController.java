package edu.nit.librarymanage.controller;

import edu.nit.librarymanage.persist.FaceRepository;
import edu.nit.librarymanage.persist.FaceEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RequestMapping("face")
@RestController
public class FaceController {
    private final FaceRepository faceRepository;

    public FaceController(FaceRepository faceRepository) {
        this.faceRepository = faceRepository;
    }

    @PostMapping
    public Long upload(
            @RequestParam("face") MultipartFile face
    ) throws IOException {

        String s = Base64.getEncoder().encodeToString(face.getBytes());
        FaceEntity f = new FaceEntity();
        f.setContent(s);
        f.setName(face.getName());
        f.setContentType(face.getContentType());
        FaceEntity save = faceRepository.save(f);
        return save.getId();
    }
}
