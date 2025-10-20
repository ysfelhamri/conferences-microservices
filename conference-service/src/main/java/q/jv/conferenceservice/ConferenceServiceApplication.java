package q.jv.conferenceservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import q.jv.conferenceservice.entities.Conference;
import q.jv.conferenceservice.entities.Review;
import q.jv.conferenceservice.enums.ConferenceType;
import q.jv.conferenceservice.feign.KeynoteRestClient;
import q.jv.conferenceservice.models.Keynote;
import q.jv.conferenceservice.repository.ConferenceRepository;
import q.jv.conferenceservice.repository.ReviewRepository;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class ConferenceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConferenceServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(ConferenceRepository conferenceRepository, ReviewRepository reviewRepository, KeynoteRestClient keynoteRestClient) {
        return args -> {
            Collection<Keynote> keynotes = keynoteRestClient.getAllKeynotes().getContent();
            keynotes.forEach(keynote -> {
                Conference conference = Conference.builder()
                        .date(new Date())
                        .duration((long) 240.0)
                        .title("conference")
                        .score(new Random().nextLong())
                        .type(ConferenceType.ACADEMIC)
                        .inscriptions(50)
                        .keynote(keynote)
                        .keynoteId(keynote.getId())
                        .build();
                conferenceRepository.save(conference);
                for (int i = 0; i < 9; i++) {
                    Review review = Review.builder()
                            .conference(conference)
                            .text("Review" + i+1)
                            .date(new Date())
                            .stars(1+ new Random().nextInt(5))
                            .build();
                    reviewRepository.save(review);
                }
            });
        };

    }

}
