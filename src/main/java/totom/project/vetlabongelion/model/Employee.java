package totom.project.vetlabongelion.model;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.FieldNameConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
import totom.project.vetlabongelion.service.DepartmentService;

@Data
@FieldNameConstants
@Slf4j
public class Employee {

    @Id
    private Long id;
    private String name;
    private String jobTitle;
    private Long depId;
    private Department department;
    public Employee(Long id, String name, String jobTitle, Long depId){
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.depId = depId;
        log.info("Employee has been setted");
    }
    public String getDepartmentName(){
        return department.getName();
    }


}
