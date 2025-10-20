package q.jv.conferenceservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import q.jv.conferenceservice.models.Keynote;

@FeignClient(name = "keynote-service")
public interface KeynoteRestClient {
    @GetMapping("/keynotes/{id}")
    Keynote findKeynoteById(@PathVariable Long id);

    @GetMapping("/keynotes")
    PagedModel<Keynote> getAllKeynotes();
}
