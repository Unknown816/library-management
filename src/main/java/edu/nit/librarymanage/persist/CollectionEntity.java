package edu.nit.librarymanage.persist;

import lombok.Data;

import javax.persistence.*;

@Table(name = "collection")
@Data
@Entity
public class CollectionEntity {

    @GeneratedValue
    @Id
    private Long id;

    @ManyToOne
    BookEntity book;

    @ManyToOne
    BookShelfEntity bookShelf;
}
