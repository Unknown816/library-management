package edu.nit.librarymanage.persist;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name="notice")
@Data
@Entity
public class NoticeEntity {
    @GeneratedValue
    @Id
    private Long id;

    private String title;
    private String content;
    private String author;
    private Date createdDate;
    private Integer click;
}
