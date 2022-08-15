package sagengaliyev.project.salarycalculator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sagengaliyev.project.salarycalculator.models.Employee;

/**
 * Репозиторий для сущности Employee, чтобы мы могли сохранять, изменять,удалять сущность Employee с Базы Данных
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
