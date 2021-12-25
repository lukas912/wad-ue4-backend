package eu.lukasnowy.wadue4.Model;

import eu.lukasnowy.wadue4.Enum.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Task {
    @Getter
    @Setter
    @Id
    Integer id;

    @Getter
    @Setter
    String title;

    @Getter
    @Setter
    String description;

    @Getter
    @Setter
    Status status;

    @Getter
    @Setter
    Date deadline;

    @Getter
    @Setter
    String contactMail;

    @Getter
    @Setter
    String url;
}
