package roman.levko.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import roman.levko.demo.dto.request.ClientRequest;
import roman.levko.demo.service.ClientService;

@RestController
@RequestMapping ("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public void create (@RequestBody ClientRequest request) {
        clientService.create(request);
    }
}
