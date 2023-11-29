package totom.project.vetlabongelion.model;

import lombok.Data;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.Id;

@Data
@FieldNameConstants
public class Employee {
    @Id
    private Long id;
    private String name;
    private String jobTitle;
    private Long depId;


    public Employee(Long id, String name, String jobTitle, Long depId){
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.depId = depId;
    }
}
