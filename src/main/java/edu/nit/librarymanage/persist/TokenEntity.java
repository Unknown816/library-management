package edu.nit.librarymanage.persist;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Table(name = "token")
@Data
@Entity
public class TokenEntity {

    @GeneratedValue
    @Id
    private Long id;
    @Column(length = 32)
    String token;

    Long userid;

    @CreatedDate
    Date createTime;

}
