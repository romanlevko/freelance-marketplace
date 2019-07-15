package roman.levko.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import roman.levko.demo.dto.request.TranslatorRequest;
import roman.levko.demo.dto.response.TranslatorResponse;
import roman.levko.demo.entity.Category;
import roman.levko.demo.entity.Translator;
import roman.levko.demo.repository.CategoryRepository;
import roman.levko.demo.repository.TranslatorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TranslatorService {

    @Autowired
    TranslatorRepository translatorRepository;

    @Autowired
    CategoryService categoryService;

    public void create(TranslatorRequest request) {
        translatorRepository.save(translatorRequestToTranslator(null, request));
    }

    public void update (Long id, TranslatorRequest request) {
        translatorRepository.save(translatorRequestToTranslator(findOne(id), request));
    }

    public void delete(Long id) {
        translatorRepository.delete(findOne(id));
    }

    private Translator translatorRequestToTranslator(Translator translator, TranslatorRequest request) {
        if (translator == null) {
            translator = new Translator();
        }

        translator.setFirstName(request.getFirstName());
        translator.setSecondName(request.getSecondName());
        translator.setUsername(request.getUsername());
        translator.setPassword(request.getPassword());
        translator.setCountry(request.getCountry());
        translator.setCity(request.getCity());
        translator.setAge(request.getAge());
        translator.setYearsOfExperience(request.getYearsOfExperience());
        translator.setRanking(request.getRanking());

        if (request.getCategories() != null) {
            List<Category> collect = request.getCategories().stream().map(categoryService::findOne).collect(Collectors.toList());
        }
        return translator;

    }

    public Translator findOne(Long id) {
        return translatorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Translator with id " + id + " not exists"));
    }


    public List<TranslatorResponse> findAll() {
        return translatorRepository.findAll()
                .stream()
                .map(TranslatorResponse::new)
                .collect(Collectors.toList());
    }

}
