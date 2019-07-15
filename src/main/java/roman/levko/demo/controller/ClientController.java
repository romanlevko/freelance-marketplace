package roman.levko.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import roman.levko.demo.dto.request.ClientRequest;
import roman.levko.demo.dto.response.ClientResponse;
import roman.levko.demo.service.ClientService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public void create(@Valid @RequestBody ClientRequest request) {
        clientService.create(request);
    }

    @GetMapping
    public List<ClientResponse> findAll() {
        return clientService.findAll();
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody ClientRequest request) {
        clientService.update(id, request);
    }

    @DeleteMapping
    public void delete(Long id) {
        clientService.delete(id);
    }
}
