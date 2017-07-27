import org.junit.*;

import org.junit.rules.ExpectedException;

import java.lang.IllegalArgumentException;
import java.util.Set;

import static org.junit.Assert.*;

public class EventLogTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void IllegalArgumentException()  {

        thrown.expect(IllegalArgumentException.class);


        Event nullEvent = new Event();
        EventLog exceptionEventLog = new EventLog();

        exceptionEventLog.addEvent(null);



    }

    @Test
    public void eventlogTest() {
        Event event = new Event();
        EventLog EventLog = new EventLog();
        event.setAction("jump");
        event.setName("melo");

        boolean successfullAdd = EventLog.addEvent(event);

        assertTrue(successfullAdd);

        Assert.assertEquals("the event was not added succesfully", successfullAdd, true);
        Assert.assertEquals("the event was not logged", EventLog.getNumEvents(),1);
    }
}
