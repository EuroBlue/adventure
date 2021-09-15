import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrtTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    public void testOrt()
    {
        Ort locus=new Ort("expected");
        assertEquals("expected", locus.name);
        assertNull(locus.links);
        assertNull(locus.rechts);
        assertNull(locus.oben);
        assertNull(locus.unten);
    }
}