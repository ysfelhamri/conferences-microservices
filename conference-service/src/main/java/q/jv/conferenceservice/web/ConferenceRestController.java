package q.jv.conferenceservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import q.jv.conferenceservice.entities.Conference;
import q.jv.conferenceservice.feign.KeynoteRestClient;
import q.jv.conferenceservice.repository.ConferenceRepository;
import q.jv.conferenceservice.repository.ReviewRepository;

@RestController
public class ConferenceRestController {
    @Autowired
    private ConferenceRepository conferenceRepository;
    @Autowired
    private KeynoteRestClient keynoteRestClient;

    @GetMapping("/conferences/{id}")
    public Conference getConference(@PathVariable Long id) {
        Conference conference = conferenceRepository.findById(id).get();
        conference.setKeynote(keynoteRestClient.findKeynoteById(conference.getKeynoteId()));
        return conference;
    }
}
