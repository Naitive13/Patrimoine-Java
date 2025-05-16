import static com.titan.model.Argent.ariary;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.titan.model.Materiel;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class PossessionTest {
  @Test
  void projection_future_pour_un_materiel() {
    var ordinateur =
        new Materiel(
            "ordinateur",
            ariary(2_000_000),
            LocalDate.of(2021, 10, 26),
            LocalDate.of(2021, 10, 26),
            0.1d);

    Materiel ordinateur1Janv2022 = ordinateur.projectionFuture(LocalDate.of(2022, 1, 1));
    Materiel ordinateur1Janv2023 = ordinateur.projectionFuture(LocalDate.of(2023, 1, 1));

    assertEquals(1_800_000, ordinateur1Janv2022.getValeur().getMontant(), "projection future du 1 Janvier 2022");
    assertEquals(1_620_000, ordinateur1Janv2023.getValeur().getMontant(),"projection future du 1 Janvier 2023");
  }
}
