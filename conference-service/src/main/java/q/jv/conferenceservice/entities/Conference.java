package q.jv.conferenceservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import q.jv.conferenceservice.enums.ConferenceType;

import java.util.Date;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter
@Setter
@Builder
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private ConferenceType type;
    private Date date;
    private Long duration;
    private int inscriptions;
    private Long score;
    private Long keynoteId;
}
