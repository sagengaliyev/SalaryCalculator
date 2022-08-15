package sagengaliyev.project.salarycalculator.services;

import org.springframework.stereotype.Service;
import sagengaliyev.project.salarycalculator.dto.EmployeeDTO;
import sagengaliyev.project.salarycalculator.mappers.EmployeeMapper;
import sagengaliyev.project.salarycalculator.models.Employee;
import sagengaliyev.project.salarycalculator.repositories.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A class marked with the @Service annotation for the Employee entity to write business logic related to the Employee entity
 */
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }


    /**
     * method for removing all employees from the database
     * @return
     */
    public List<EmployeeDTO> getEmployee() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * The method for calculating the final salary in proportion to the time
     * worked takes an EmployeeDTO object in JSON format, extracts the necessary data from it, saves it to a database (MySQL)
     * and returns the final salary:totalAmount
     * @param employeeDTO
     * @return
     */
    public long getTotalAmount(EmployeeDTO employeeDTO){
        Employee employee = employeeMapper.toEntity(employeeDTO);
        long salary = employeeDTO.getSalary();
        int startTime = employeeDTO.getStartTime().getHour();
        int endTime = employeeDTO.getEndTime().getHour();
        int totalHours=endTime-startTime;
        int timeWorked=totalHours*60;
        employee.setTimeWorked(timeWorked);
        long totalAmount = salary/22*16;
        employee.setTotalAmount(totalAmount);
        employeeRepository.save(employee);
        return totalAmount;
    }
}
