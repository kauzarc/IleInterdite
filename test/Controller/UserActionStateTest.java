package Controller;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class UserActionStateTest extends TestCase {
    static UserActionState instance = UserActionState.getInstance();

    @Before
    public void setUp() throws Exception {
        instance.reset();
    }

    @Test
    public void testActionCount() {
        assertEquals(0, instance.getActionCount());

        instance.actionCountUp();
        assertEquals(1, instance.getActionCount());

        instance.actionCountUp();
        assertEquals(2, instance.getActionCount());

        instance.actionCountUp();
        assertEquals(3, instance.getActionCount());

        instance.actionCountReset();
        assertEquals(0, instance.getActionCount());
    }

    @Test
    public void testReset() {
        assertEquals(0, instance.getActionCount());
        assertEquals(UserActionState.Mode.moving, instance.getMod());
    }
}