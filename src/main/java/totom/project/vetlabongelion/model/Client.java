package totom.project.vetlabongelion.model;

import lombok.Data;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.Id;
@Data
@FieldNameConstants
public class Client{
    @Id
    private Long id;
    private String name;
    private String company;

    public Client(Long id, String name, String company){
        this.id = id;
        this.name = name;
        this.company = company;
    }
}
