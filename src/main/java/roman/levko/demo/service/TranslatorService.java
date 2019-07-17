package roman.levko.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import roman.levko.demo.dto.request.PaginationRequest;
import roman.levko.demo.dto.request.TranslatorRequest;
import roman.levko.demo.dto.response.PageResponse;
import roman.levko.demo.dto.response.TranslatorResponse;
import roman.levko.demo.entity.Category;
import roman.levko.demo.entity.Translator;
import roman.levko.demo.repository.TranslatorRepository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TranslatorService {

    @Autowired
    TranslatorRepository translatorRepository;

    @Autowired
    CategoryService categoryService;

    @Autowired
    FileService fileService;

    public void create(TranslatorRequest request) {
        translatorRepository.save(translatorRequestToTranslator(null, request));
    }

    public PageResponse<TranslatorResponse> findPage(PaginationRequest paginationRequest) {

        Page<Translator> page = translatorRepository.findAll(paginationRequest.toPageable());
        return new PageResponse<>(page.getTotalPages(),
                page.getTotalElements(),
                page.get().map(TranslatorResponse::new).collect(Collectors.toList()));
    }

    public void update(Long id, TranslatorRequest request) {
        translatorRepository.save(translatorRequestToTranslator(findOne(id), request));
    }

    public void delete(Long id) {
        translatorRepository.delete(findOne(id));
    }

    private Translator translatorRequestToTranslator(Translator translator, TranslatorRequest request) {
        if (translator == null) {
            translator = new Translator();
        }

        if (request.getImage() != null && !request.getImage().isEmpty()) {
            String path = null;
            try {
                path = fileService.saveFile(request.getImage());
            } catch (IOException e) {
                e.printStackTrace();
            }
            translator.setImage(path);
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
            translator.setCategories(collect);
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
