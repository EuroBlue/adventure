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
        Game g=new Game();
        assertNotNull(g.user);
    }
    @Test
    public void testgewonnen()
    {
        Ort parkplatz=new Ort("Parkplatz");
        Player p=new Player(parkplatz);
        assertEquals(parkplatz,p.getStandort());
    }
}