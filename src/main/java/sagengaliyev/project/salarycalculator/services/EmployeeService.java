package sagengaliyev.project.salarycalculator.services;

import org.springframework.stereotype.Service;
import sagengaliyev.project.salarycalculator.dto.EmployeeDTO;
import sagengaliyev.project.salarycalculator.mappers.EmployeeMapper;
import sagengaliyev.project.salarycalculator.models.Employee;
import sagengaliyev.project.salarycalculator.repositories.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс помеченный аннотацией @Service для сущности Employee, чтобы писать бизнес логику связанную с сущностью Employee
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
     * метод для вывода всех работников с Базы Данных
     * @return
     */
    public List<EmployeeDTO> getEmployee() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Метод для расчета итоговой зарплаты пропорционально отработанному времени
     * принимает объект EmployeeDTO в формате JSON, извлекает из него нужные данные, сохраняет в базу данных(MySQL)
     * и возвращает итоговую зарплату:totalAmount
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
