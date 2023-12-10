package totom.project.vetlabongelion.model;

import lombok.Data;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@FieldNameConstants
public class Protocol {
    @Id
    private Long id;
    private Long clientId;
    private Date date;
    private Long employeeId;
    private Client client;
    private Employee employee;

    public Protocol(Long id, Long clientId, Date date, Long employeeId){
        this.id = id;
        this.clientId = clientId;
        this.date = date;
        this.employeeId = employeeId;
    }
}
