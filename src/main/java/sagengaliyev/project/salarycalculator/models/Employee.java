package sagengaliyev.project.salarycalculator.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Employee entity that stores attributes such as:
 * employeeId employee id, salary - fixed salary,
 * startTime, endTime - the time of the beginning and end of the employee's working day
 * timeWorked - the time worked on a given day in minutes,
 * totalAmount - the total salary in proportion to the time worked
 */
@Data
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;
    @Column(name = "salary")
    private long salary;
    @Column(name = "start_time")
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    private LocalDateTime startTime;
    @Column(name = "end_time")
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    private LocalDateTime endTime;
    @Column(name = "time_worked")
    private long timeWorked;
    @Column(name = "total_amount")
    private long totalAmount;
}
