package edu.nit.librarymanage.persist;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Table(name = "users")
@Data
@Entity
public class UserEntity {

    @GeneratedValue
    @Id
    private Long id;

    @Column(length = 32)
    private String name;

    @Column(length = 32)
    private String password;

    @Column(length = 32)
    private String sex;

    private String qx;

    @CreatedDate
    private Date createDate;

    @ManyToOne
    FaceEntity face;

    public String getFileBase64() {
        if (face == null) return "";
        return String.format("data:%s;base64,%s", face.contentType, face.content);
    }

}
