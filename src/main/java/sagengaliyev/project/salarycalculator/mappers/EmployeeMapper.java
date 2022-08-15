package sagengaliyev.project.salarycalculator.mappers;

import org.springframework.stereotype.Component;
import sagengaliyev.project.salarycalculator.dto.EmployeeDTO;
import sagengaliyev.project.salarycalculator.models.Employee;

/**
 * A mapper for the Employee entity, which has two methods: to DTO and to Entity, for conversion
  DTO objects into an entity and vice versa
 */
@Component
public class EmployeeMapper {
    /**
     * A method that converts an entity into a DTO object and returns it
     * @param employee
     * @return
     */
    public EmployeeDTO toDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeId(employee.getEmployeeId());
        employeeDTO.setSalary(employee.getSalary());
        employeeDTO.setStartTime(employee.getStartTime());
        employeeDTO.setEndTime(employee.getEndTime());
        employeeDTO.setTimeWorked(employee.getTimeWorked());
        employeeDTO.setTotalAmount(employee.getTotalAmount());
        return employeeDTO;
    }

    /**
     * A method that takes a DTO object and converts it into an entity (to save the object's data to a Database)
     * and returns this entity
     * @param employeeDTO
     * @return
     */

    public Employee toEntity(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setEmployeeId(employeeDTO.getEmployeeId());
        employee.setSalary(employeeDTO.getSalary());
        employee.setStartTime(employeeDTO.getStartTime());
        employee.setEndTime(employeeDTO.getEndTime());
        employee.setTimeWorked(employeeDTO.getTimeWorked());
        employee.setTotalAmount(employeeDTO.getTotalAmount());
        return employee;
    }
}
