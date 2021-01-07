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
    private String category;
    private String publisher;
    private Date publishDate;
    private Long pages;
    private String brifContent;
    private Integer click;

    @ManyToOne
    FileEntity file;

    public String getFileBase64() {
        if (file == null) return "";
        return String.format("data:%s;base64,%s", file.contentType, file.content);
    }
}
