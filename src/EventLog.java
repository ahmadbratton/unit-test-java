import java.util.*;

public class EventLog {
    String name;
    String action;
    private List<Event> eventList;


    public EventLog ( ){

        eventList = new ArrayList<>();

    }

    public boolean addEvent(Event event) {
        if (event == null || event.getAction() == null|| event.getName() == null){
            throw new IllegalArgumentException("ERROR EVENT IS NULL ");
        }else if (!event.getAction().equals("Face2Face") && !event.getAction().equals("PhoneCall")&&!event.getAction().equals("TextMessaging")&&!event.getAction().equals("Unknown")){
            throw new IllegalArgumentException("ERROR EVENT IS not correct ");
        }

        else{
        System.out.println(event);
        eventList.add(event);
        return true;
        }
    }

    public int getNumEvents (){
        return eventList.size();
    }




}
