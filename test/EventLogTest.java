import jdk.nashorn.internal.codegen.types.Type;
import org.junit.*;

import org.junit.rules.ExpectedException;

import java.lang.IllegalArgumentException;
import java.util.*;

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

        Event nameEvent = new Event();
        nameEvent.setAction("jump");
        nameEvent.setName("melo");

        exceptionEventLog.addEvent(nameEvent);



    }

    @Test
    public void eventlogTest() {


        Event event = new Event();
        EventLog EventLog = new EventLog();
        event.setAction("Face2Face");
        event.setName("marlin");

        boolean successfullAdd = EventLog.addEvent(event);

        Assert.assertEquals("the event was not added succesfully", successfullAdd, true);
        Assert.assertEquals("wrong number of events", EventLog.getNumEvents(),1);

        Event event1 = new Event();
        event1.setAction("PhoneCall");
        event1.setName("sean");

        boolean successfullAdd1 = EventLog.addEvent(event1);

        Assert.assertEquals("the event was not added succesfully", successfullAdd1, true);
        Assert.assertEquals("wrong number of events", EventLog.getNumEvents(),2);


        Event event2 = new Event();
        EventLog EventLog2 = new EventLog();
        event2.setAction("TextMessaging");
        event2.setName("gabby");

        boolean successfullAdd2 = EventLog2.addEvent(event1);

        Assert.assertEquals("the event was not added succesfully", successfullAdd2, true);
        Assert.assertEquals("wrong number of events", EventLog2.getNumEvents(),1);


        Event event3 = new Event();
        event3.setAction("Unknown");
        event3.setName("steve");

        boolean successfullAdd3 = EventLog.addEvent(event3);

        Assert.assertEquals("the event was not added succesfully", successfullAdd3, true);
        Assert.assertEquals("wrong number of events", EventLog.getNumEvents(),3);

    }

    @Test
    public void checkType() {
        Event eventType = new Event();
       eventType.setName("joe");
       eventType.setAction("eat");

       Assert.assertEquals("this type is not a string ", eventType.getAction().getClass().equals(Type.STRING) ,false);

    }
}
