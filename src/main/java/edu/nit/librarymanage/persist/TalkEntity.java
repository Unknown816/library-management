package edu.nit.librarymanage.persist;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "talk")
@Data
@Entity
public class TalkEntity {
    @GeneratedValue
    @Id
    private Long id;
    private Long uid;
    private String name;
    private String content;
    private Long callId;
    private String callName;
    private Date talkDate;
}
