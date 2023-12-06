package totom.project.vetlabongelion.model;

import lombok.Data;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@FieldNameConstants
public class ResearchType {
    @Id
    private Long id;
    private String type;
    private Long departmentId;

    public ResearchType(Long id, String type, Long departmentId){
        this.id = id;
        this.type = type;
        this.departmentId = departmentId;
    }
}
