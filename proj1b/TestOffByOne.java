import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    static CharacterComparator cc = new OffByOne();

    @Test
    public void testEqualChars(){

        assertTrue(cc.equalChars('a', 'b'));
        assertFalse(cc.equalChars('a', 'c'));
        assertFalse(cc.equalChars('A', 'b'));
        assertFalse(cc.equalChars('a', 'a'));
        assertTrue(cc.equalChars('&', '%'));
        
    }

}
