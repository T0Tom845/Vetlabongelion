package totom.project.vetlabongelion.model;

import lombok.Data;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@FieldNameConstants
public class Sample {
    @Id
    private Long id;
    private String type;
    private String name;
    private Long amount;

    public Sample(Long id, String type, String name, Long amount){
        this.id = id;
        this.type = type;
        this.name = name;
        this.amount = amount;
    }
}
