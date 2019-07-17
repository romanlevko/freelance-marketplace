package roman.levko.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import roman.levko.demo.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
