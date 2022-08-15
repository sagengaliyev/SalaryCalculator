package sagengaliyev.project.salarycalculator.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Column;
import java.time.LocalDateTime;


/**
 * DTO object of the Employee entity
 */
@Data
public class EmployeeDTO {
    private long employeeId;
    private long salary;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss a")
    private LocalDateTime startTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss a")
    private LocalDateTime endTime;
    private long timeWorked;
    private long totalAmount;


}
