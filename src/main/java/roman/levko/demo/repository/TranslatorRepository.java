package roman.levko.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import roman.levko.demo.entity.Translator;

@Repository
public interface TranslatorRepository extends JpaRepository<Translator, Long> {
}
