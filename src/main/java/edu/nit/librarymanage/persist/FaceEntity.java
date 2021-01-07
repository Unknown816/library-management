package edu.nit.librarymanage.persist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Table(name = "face")
@Data
@Entity
public class FaceEntity {
    @Id
    @GeneratedValue
    Long id;

    String name;

    @JsonIgnore
    @Lob
    String content;

    String contentType;
}
