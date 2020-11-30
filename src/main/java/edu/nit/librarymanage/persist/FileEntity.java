package edu.nit.librarymanage.persist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Table(name = "file")
@Data
@Entity
public class FileEntity {

    @Id
    @GeneratedValue
    Long id;

    String name;

    @JsonIgnore
    @Lob
    String content;

    String contentType;
}
