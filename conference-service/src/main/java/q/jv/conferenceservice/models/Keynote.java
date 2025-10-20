package q.jv.conferenceservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Keynote {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String function;
}
