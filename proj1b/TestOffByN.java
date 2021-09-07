import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByN {

    @Test
    public void testEqualChars() {

        OffByN cc = new OffByN(5);
        assertTrue(cc.equalChars('a', 'f'));
        assertFalse(cc.equalChars('a', 'g'));
        assertFalse(cc.equalChars('A', 'f'));
        assertFalse(cc.equalChars('a', 'a'));
        assertTrue(cc.equalChars('f', 'a'));

    }

}
