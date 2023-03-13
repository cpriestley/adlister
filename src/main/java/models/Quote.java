package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Quote implements Serializable {

    private static final long serialVersionUID = 1L;
    private Author author;
    private String content;


}