package q.jv.conferenceservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String text;
    private int stars;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Conference conference;
}
