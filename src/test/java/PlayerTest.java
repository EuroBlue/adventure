import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    public void testPlayer()
    {
        Ort locus=new Ort("name");
        Player player=new Player(locus);
        assertNotNull(player);
        assertEquals(locus, player.standort);
    }
    @Test
    public void testWalk()
    {
        Ort _1=new Ort("1");
        Ort _2=new Ort("2");
        _1.links=_2;
        Player player=new Player(_1);
        player.walk("links");
        assertEquals(_2, player.standort);
        player.walk("links");
        assertEquals(_2, player.standort);
    }
}