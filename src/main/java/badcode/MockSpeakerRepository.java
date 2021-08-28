package badcode;

public class MockSpeakerRepository implements SpeakerRepository {
    @Override
    public Integer saveSpeaker(Speaker speaker) {
        return 1;
    }
}