import static org.junit.Assert.*;
import org.junit.Test;
public class GameTest
{
    public GameTest()
    {
    }
    @Test
    public void testGame()
    {
        Game g=new Game("test");
        assertNotNull(g.user);
    }
    @Test
    public void testgewonnen()
    {
        Ort parkplatz=new Ort("Parkplatz");
        Player p=new Player(parkplatz,"test");
        assertEquals(parkplatz,p.getStandort());
    }
}