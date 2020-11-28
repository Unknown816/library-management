package edu.nit.librarymanage.persist;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "book")
@Data
@Entity
@SequenceGenerator(name="SeqGen2",sequenceName="book_sequence")
public class BookEntity {

    @GeneratedValue(generator="SeqGen2")
    @Id
    private Long id;

    @Column(length = 32)
    private String name;
    private String authors;
    private Category category;
    private String barcode;
    private String publisher;
    private Date publishDate;
}
