package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Ad {
    private long id;
    @NonNull
    private long userId;
    @NonNull
    private String title;
    @NonNull
    private String description;
}
