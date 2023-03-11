package beans;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Ad {
    private long id;
    private long userId;
    private String title;
    private String description;
}
