import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Clients {
    private int id;
    private String firstName;
    private String cardAliace;
    private String cardId;
}
