package sagengaliyev.project.salarycalculator.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Сущность Employee в которой хранятся такие атрибуты как:
 * employeeId id работника, salary - фиксированная зарплата, starTime, endTime - время начало и конца рабочего дня работника
 * timeWorked - время проработанное в данный день в минутах,
 * totalAmount - итоговая зарплата пропорционально отработанному времени
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
