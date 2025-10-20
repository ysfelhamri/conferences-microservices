package q.jv.keynoteservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import q.jv.keynoteservice.entities.Keynote;
import q.jv.keynoteservice.repository.KeynoteRepository;

@SpringBootApplication
public class KeynoteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeynoteServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KeynoteRepository keynoteRepository) {
        return args -> {
            keynoteRepository.save(Keynote.builder()
                    .firstName("Youssef")
                    .lastName("EL HAMRI")
                    .email("ysf@mail.com")
                    .function("conf")
                    .build());
            keynoteRepository.save(Keynote.builder()
                    .firstName("test")
                    .lastName("tttt")
                    .email("tst@mail.com")
                    .function("conf1")
                    .build());
            keynoteRepository.save(Keynote.builder()
                    .firstName("test2")
                    .lastName("tttt")
                    .email("tst2@mail.com")
                    .function("conf2")
                    .build());
        };
    }

}
