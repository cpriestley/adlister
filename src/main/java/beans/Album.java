package beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Album implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private long id;
    private String artist;
    private String name;
    private LocalDate release_date;
    private BigDecimal Sales;
    private String genre;
}
