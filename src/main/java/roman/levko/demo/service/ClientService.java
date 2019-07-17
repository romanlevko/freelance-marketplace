package roman.levko.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import roman.levko.demo.dto.request.ClientRequest;
import roman.levko.demo.dto.request.PaginationRequest;
import roman.levko.demo.dto.response.ClientResponse;
import roman.levko.demo.dto.response.PageResponse;
import roman.levko.demo.entity.Category;
import roman.levko.demo.entity.Client;
import roman.levko.demo.entity.Job;
import roman.levko.demo.repository.ClientRepository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private JobService jobService;

    @Autowired
    private FileService fileService;

    public void create(ClientRequest request) {
        clientRepository.save(clientRequestToClient(null, request));
    }

    public PageResponse<ClientResponse> findPage(PaginationRequest paginationRequest) {

        Page<Client> page = clientRepository.findAll(paginationRequest.toPageable());
        return new PageResponse<>(page.getTotalPages(),
                page.getTotalElements(),
                page.get().map(ClientResponse::new).collect(Collectors.toList()));

    }

    public void update(Long id, ClientRequest request) {
        clientRepository.save(clientRequestToClient(findOne(id), request));
    }

    public void delete(Long id) {
        clientRepository.delete(findOne(id));
    }

    private Client clientRequestToClient(Client client, ClientRequest request) {
        if (client == null) {
            client = new Client();
        }

        if (request.getImage() != null && !request.getImage().isEmpty()) {
            String path = null;
            try {
                path = fileService.saveFile(request.getImage());
            } catch (IOException e) {
                e.printStackTrace();
            }
            client.setImage(path);
        }

        client.setName(request.getName());
        client.setUsername(request.getUsername());
        client.setPassword(request.getPassword());
        client.setCountry(request.getCountry());
        client.setCity(request.getCity());
        client.setRanking(request.getRanking());

        if (request.getJobs() != null) {
            List<Job> collect = request.getJobs().stream().map(jobService::findOne).collect(Collectors.toList());
            client.setJobs(collect);
        }

        if (request.getCategories() != null) {
            List<Category> collect = request.getCategories().stream().map(categoryService::findOne).collect(Collectors.toList());
            client.setCategories(collect);
        }

        return client;

    }

    public Client findOne(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Client with id " + id + " not exists"));
    }


    public List<ClientResponse> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(ClientResponse::new)
                .collect(Collectors.toList());
    }
}
