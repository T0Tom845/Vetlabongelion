package totom.project.vetlabongelion.model;

import lombok.Data;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@FieldNameConstants
public class Research {
    @Id
    private Long id;
    private Long typeId;
    private Long protId;
    private Date date;
    private Long requestId; //TODO: id в бд поставить на первое место в названии

    public Research(Long id, Long typeId, Long protId, Date date, Long requestId) {
        this.id = id;
        this.typeId = typeId;
        this.protId = protId;
        this.date = date;
        this.requestId = requestId;
    }
}
