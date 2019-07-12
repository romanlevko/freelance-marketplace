package roman.levko.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import roman.levko.demo.dto.request.ClientRequest;
import roman.levko.demo.entity.Assignment;
import roman.levko.demo.entity.Client;
import roman.levko.demo.entity.Job;
import roman.levko.demo.repository.AssignmentRepository;
import roman.levko.demo.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private JobService jobService;

    public void create (ClientRequest request) {
        Client client = new Client();
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

        clientRepository.save(client);


    }
}
