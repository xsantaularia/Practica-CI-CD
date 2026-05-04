import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompteBancariTest {

    private CompteBancari compte;
    private static final double MARGE_ERROR = 0.0001;

    @BeforeEach
    void setUp() {
        compte = new CompteBancari("Joan Perez", "ES12345678901234567890", 1000.0);
    }

    @Test
    void creacioCorrectaTest() {
        assertEquals("Joan Perez", compte.getTitular());
        assertEquals("ES12345678901234567890", compte.getIban());
        assertEquals(1000.0, compte.getSaldo(), MARGE_ERROR);
    }

    @Test
    void ingressarCorrecteTest() {
        compte.ingressar(500.0);
        assertEquals(9999.0, compte.getSaldo(), MARGE_ERROR);
    }

    @Test
    void retirarCorrecteTest() {
        compte.retirar(200.0);
        assertEquals(800.0, compte.getSaldo(), MARGE_ERROR);
    }
}