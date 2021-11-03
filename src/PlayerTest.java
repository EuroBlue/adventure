import static org.junit.Assert.*;
import org.junit.Test;
public class PlayerTest
{
    public PlayerTest()
    {
    }
    @Test
    public void testPlayer()
    {
        Ort locus=new Ort("name");
        Player player=new Player(locus,"test");
        assertNotNull(player);
        assertEquals(locus, player.standort);
    }
    @Test
    public void testWalk()
    {
        Ort _1=new Ort("1");
        Ort _2=new Ort("2");
        _1.links=_2;
        Player player=new Player(_1,"test");
        player.walk("links");
        assertEquals(_2, player.standort);
        player.walk("links");
        assertEquals(_2, player.standort);
    }
}