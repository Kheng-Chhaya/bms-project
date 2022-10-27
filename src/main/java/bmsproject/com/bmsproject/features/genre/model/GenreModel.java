package bmsproject.com.bmsproject.features.genre.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class GenreModel {
    private Integer id;
    private String title;
    private String description;
    private Integer icon;
    private Boolean isEnabled;

}
