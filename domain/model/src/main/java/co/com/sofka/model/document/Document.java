package co.com.sofka.model.document;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Document {
    private String id;
    private String name;
    private String uri;
}