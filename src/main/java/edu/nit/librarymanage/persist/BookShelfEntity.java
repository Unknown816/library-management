package edu.nit.librarymanage.persist;

import lombok.Data;

import javax.persistence.*;

@Table(name = "bookshelf")
@Data
@Entity
public class BookShelfEntity {

    @GeneratedValue
    @Id
    private Long id;
    private Long userId;

//    @OneToOne(mappedBy = "bookShelf")
//    private UserEntity user;

}
