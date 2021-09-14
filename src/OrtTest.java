import static org.junit.Assert.*;
import org.junit.Test;
public class OrtTest
{
    public OrtTest()
    {
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