package roman.levko.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import roman.levko.demo.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

}