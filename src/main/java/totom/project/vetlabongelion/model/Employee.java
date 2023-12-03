package totom.project.vetlabongelion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldNameConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import totom.project.vetlabongelion.service.DepartmentService;

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
