package edu.nit.librarymanage.persist;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "users")
@Data
@Entity
@SequenceGenerator(name="SeqGen1",sequenceName="user_sequence")
public class UserEntity {

    @GeneratedValue(generator="SeqGen1")
    @Id
    private Long id;

    @Column(length=32)
    private String name;
    private String password;
    private Date createDate;

}
