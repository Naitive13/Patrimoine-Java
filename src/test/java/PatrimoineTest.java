import static com.titan.model.Devise.ARIARY;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.titan.model.Argent;
import com.titan.model.Materiel;
import com.titan.model.Patrimoine;
import com.titan.model.Personne;
import java.time.LocalDate;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class PatrimoineTest {

  @Test
  void projection_future_du_patrimoine() {
    Personne personne = new Personne("James");
    Argent valeurTshirt = new Argent(20_000d, ARIARY);
    Materiel tshirt =
        new Materiel(
            "T-shirt", valeurTshirt, LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 1), 20d);
    Argent valeurSmartphone = new Argent(1_000_000d, ARIARY);
    Materiel smartphone =
        new Materiel(
            "Samsung", valeurSmartphone, LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 1), 10d);
    Patrimoine patrimoine =
        new Patrimoine(personne, LocalDate.now(), 0d, Set.of(tshirt, smartphone));

    Double actual1 = patrimoine.projectionFuture(LocalDate.of(2026, 1, 1));
    Double actual2 = patrimoine.projectionFuture(LocalDate.of(2030, 1, 1));

    assertEquals(916_000, actual1, "projection d'ici 1 an");
    assertEquals(597044, Math.round(actual2), "projection d'ici 5 ans");
  }
}
