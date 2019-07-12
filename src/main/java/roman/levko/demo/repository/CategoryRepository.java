package roman.levko.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import roman.levko.demo.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}

