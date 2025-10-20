package q.jv.conferenceservice.entities;

import jakarta.persistence.*;
import lombok.*;
import q.jv.conferenceservice.enums.ConferenceType;
import q.jv.conferenceservice.models.Keynote;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @Enumerated(EnumType.STRING)
    private ConferenceType type;
    private Date date;
    private Long duration;
    private int inscriptions;
    private Long score;
    private Long keynoteId;
    @OneToMany(mappedBy = "conference")
    private List<Review> reviews = new ArrayList<>();
    @Transient private Keynote keynote;
}
