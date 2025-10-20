package q.jv.conferenceservice.entities;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String text;
    private int stars;
    @ManyToOne
    private Conference conference;
}
