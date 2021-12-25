package eu.lukasnowy.wadue4.Model;

import eu.lukasnowy.wadue4.Enum.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Task {
    @Getter
    @Setter
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
