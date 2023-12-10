package totom.project.vetlabongelion.model;

import lombok.Data;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@FieldNameConstants
public class ResearchRequest {
    @Id
    private Long id;
    private Long employeeId;
    private Employee employee;
    private Long clientId;
    private Client client;
    private Date date;
    private Long sampleId;
    private Sample sample;

    public ResearchRequest(Long id, Long employeeId, Long clientId, Date date, Long sampleId) {
        this.id = id;
        this.employeeId = employeeId;
        this.clientId = clientId;
        this.date = date;
        this.sampleId = sampleId;
    }
}
