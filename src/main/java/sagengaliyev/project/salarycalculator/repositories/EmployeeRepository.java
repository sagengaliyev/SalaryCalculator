package sagengaliyev.project.salarycalculator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sagengaliyev.project.salarycalculator.models.Employee;

/**
 * Repository for the Employee entity so that we can save, modify, delete the Employee entity from the Database
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
