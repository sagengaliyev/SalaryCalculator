package sagengaliyev.project.salarycalculator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sagengaliyev.project.salarycalculator.dto.EmployeeDTO;
import sagengaliyev.project.salarycalculator.services.EmployeeService;
import java.util.List;

/**
 * a class that is a Rest Controller (because it will return a json object for each http request)
 * for the Employee entity
 *  also annotation @RequestMapping to indicate the beginning of the employee url by default
 */
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDTO>> getEmployee(){
        List<EmployeeDTO> employee = employeeService.getEmployee();
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping(value = "/salary", consumes = "application/json")
    public ResponseEntity<Long> getTotalAmount(@RequestBody EmployeeDTO employeeDTO){
        long salary = employeeService.getTotalAmount(employeeDTO);
        return new ResponseEntity<>(salary,HttpStatus.OK);
    }
}
