package roman.levko.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Translator extends JpaRepository<Translator, Long> {
}
