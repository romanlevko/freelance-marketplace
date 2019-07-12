package roman.levko.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import roman.levko.demo.entity.Assignment;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
}
