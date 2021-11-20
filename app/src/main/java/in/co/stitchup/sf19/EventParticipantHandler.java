package in.co.stitchup.sf19;

public class EventParticipantHandler
{
    String event,participants;

    public EventParticipantHandler() {

    }

    public EventParticipantHandler(String event, String participants) {
        this.event = event;
        this.participants = participants;
    }

    public String getEvent() {
        return event;
    }

    public String getParticipants() {
        return participants;
    }
}
