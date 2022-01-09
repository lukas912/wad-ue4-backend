package eu.lukasnowy.wadue4.Model;

import eu.lukasnowy.wadue4.Enum.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Task {
    @Getter
    @Setter
    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName=  "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    Integer id;

    @Getter
    @Setter
    String title;

    @Getter
    @Setter
    String longDesc;

    @Getter
    @Setter
    String shortDesc;

    @Getter
    @Setter
    Status status;

    @Getter
    @Setter
    String deadline;

    @Getter
    @Setter
    String contactMail;

    @Getter
    @Setter
    String url;
}
