package sagengaliyev.project.salarycalculator.mappers;

import org.springframework.stereotype.Component;
import sagengaliyev.project.salarycalculator.dto.EmployeeDTO;
import sagengaliyev.project.salarycalculator.models.Employee;

/**
 * Маппер для сущности Employee, который имеет два метода: toDTO и toEntity, для конвертирования
 * DTO объектов в сущность и наоборот
 */
@Component
public class EmployeeMapper {
    /**
     * Метод который конвертирует сущность в DTO объект и возвращает его
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
     * Метод который принимает объект DTO и конвертирует его в сущность (для сохранения данных объекта в Базу Данных)
     * и возвращает данную сущность
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
