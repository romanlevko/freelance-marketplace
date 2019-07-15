package roman.levko.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import roman.levko.demo.dto.request.TranslatorRequest;
import roman.levko.demo.dto.response.TranslatorResponse;
import roman.levko.demo.service.TranslatorService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/translator")
public class TranslatorController {

    @Autowired
    TranslatorService translatorService;

    @PostMapping
    public void create(@Valid  @RequestBody TranslatorRequest request) {
        translatorService.create(request);
    }

    @GetMapping
    public List<TranslatorResponse> findAll() {
        return translatorService.findAll();
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody TranslatorRequest request) {
        translatorService.update(id, request);
    }

    @DeleteMapping
    public void delete(Long id) {
        translatorService.delete(id);
    }


}
