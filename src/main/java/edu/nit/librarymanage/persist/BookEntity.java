package edu.nit.librarymanage.persist;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "book")
@Data
@Entity
public class BookEntity {

    @GeneratedValue
    @Id
    private Long id;

    @Column(length = 32)
    private String name;
    private String authors;
    private Category category;
    private String barcode;
    private String publisher;
    private Date publishDate;

    @ManyToOne
    FileEntity file;

    public String getFileBase64() {
        if (file == null) return "";
        return String.format("data:%s;base64,%s", file.contentType, file.content);
    }
}
