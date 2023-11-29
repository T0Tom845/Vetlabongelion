package totom.project.vetlabongelion.model;

import lombok.Data;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.Id;

@Data
@FieldNameConstants
public class Department {
    @Id
    private Long id;
    private String name;


    public Department(Long id, String name){
        this.id = id;
        this.name = name;
    }
}
