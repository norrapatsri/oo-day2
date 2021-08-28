package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class RegisterBusinessTest {
    //pass
    @Test
    @DisplayName("test register success")
    public void testRegisterSuccess() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("toey");
        speaker.setLastName("007");
        speaker.setEmail("toey007@live.com");
        int actual = registerBusiness.register(new MockSpeakerRepository(), speaker);
        assertEquals(1, actual);
    }

    @Test
    @DisplayName("test register success with experience 1 year.")
    public void testRegisterSuccessWithExperienceOneYear() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("toey");
        speaker.setLastName("007");
        speaker.setEmail("toey007@live.com");
        speaker.setExp(1);
        registerBusiness.register(new MockSpeakerRepository(), speaker);
        assertEquals(500, speaker.getRegistrationFee());
    }

    @Test
    @DisplayName("test register success with experience 3 year.")
    public void testRegisterSuccessWithExperienceThreeYear() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("toey");
        speaker.setLastName("007");
        speaker.setEmail("toey007@live.com");
        speaker.setExp(3);
        registerBusiness.register(new MockSpeakerRepository(), speaker);
        assertEquals(250, speaker.getRegistrationFee());
    }

    @Test
    @DisplayName("test register success with experience 5 year.")
    public void testRegisterSuccessWithExperienceFiveYear() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("toey");
        speaker.setLastName("007");
        speaker.setEmail("toey007@live.com");
        speaker.setExp(5);
        registerBusiness.register(new MockSpeakerRepository(), speaker);
        assertEquals(100, speaker.getRegistrationFee());
    }

    @Test
    @DisplayName("test register success with experience 9 year.")
    public void testRegisterSuccessWithExperienceNineYear() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("toey");
        speaker.setLastName("007");
        speaker.setEmail("toey007@live.com");
        speaker.setExp(9);
        registerBusiness.register(new MockSpeakerRepository(), speaker);
        assertEquals(50, speaker.getRegistrationFee());
    }

    //fail
    @Test
    @DisplayName("test register with out speaker first name")
    public void testRegisterWithoutSpeakerFirstName() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        ArgumentNullException thrown = assertThrows(
                ArgumentNullException.class,
                () -> registerBusiness.register(null, new Speaker())
        );
        assertEquals(thrown.getMessage(), "First name is required.");
    }

    @Test
    @DisplayName("test register with out speaker lastname")
    public void testRegisterWithoutSpeakerLastname() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("toey");
        ArgumentNullException thrown = assertThrows(
                ArgumentNullException.class,
                () -> registerBusiness.register(null, speaker)
        );
        assertEquals(thrown.getMessage(), "Last name is required.");
    }

    @Test
    @DisplayName("test register with out speaker email")
    public void testRegisterWithoutSpeakerEmail() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("toey");
        speaker.setLastName("007");
        ArgumentNullException thrown = assertThrows(
                ArgumentNullException.class,
                () -> registerBusiness.register(null, speaker)
        );
        assertEquals(thrown.getMessage(), "Email is required.");
    }

    @Test
    @DisplayName("test register empty speaker first name")
    public void testRegisterWithEmptySpeakerFirstName() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("");
        speaker.setLastName("007");
        speaker.setEmail("toey007@oo-course.com");
        ArgumentNullException thrown = assertThrows(
                ArgumentNullException.class,
                () -> registerBusiness.register(null, speaker)
        );
        assertEquals(thrown.getMessage(), "First name is required.");
    }

    @Test
    @DisplayName("test register empty speaker lastname")
    public void testRegisterWithEmptySpeakerLastname() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("toey");
        speaker.setLastName("");
        speaker.setEmail("toey007@oo-course.com");
        ArgumentNullException thrown = assertThrows(
                ArgumentNullException.class,
                () -> registerBusiness.register(null, speaker)
        );
        assertEquals(thrown.getMessage(), "Last name is required.");
    }

    @Test
    @DisplayName("test register empty speaker email")
    public void testRegisterWithEmptySpeakerEmail() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("toey");
        speaker.setLastName("007");
        speaker.setEmail("");
        ArgumentNullException thrown = assertThrows(
                ArgumentNullException.class,
                () -> registerBusiness.register(null, speaker)
        );
        assertEquals(thrown.getMessage(), "Email is required.");
    }

    @Test
    @DisplayName("test register invalid speaker email domain")
    public void testRegisterWithSpeakerInvalidEmailDomain() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("toey");
        speaker.setLastName("007");
        speaker.setEmail("toey007@oo-course.com");
        SpeakerDoesntMeetRequirementsException thrown = assertThrows(
                SpeakerDoesntMeetRequirementsException.class,
                () -> registerBusiness.register(null, speaker)
        );
        assertEquals(thrown.getMessage(), "Speaker doesn't meet our standard rules.");
    }

    @Test
    @DisplayName("test register invalid speaker email domain format.")
    public void testRegisterWithSpeakerInvalidEmailDomainFormat() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("toey");
        speaker.setLastName("007");
        speaker.setEmail("toey007");
        DomainEmailInvalidException thrown = assertThrows(
                DomainEmailInvalidException.class,
                () -> registerBusiness.register(null, speaker)
        );
        assertNull(thrown.getMessage());
    }

    @Test
    @DisplayName("test register Can't save a speaker.")
    public void testRegisterWithCantSaveSpeaker() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("toey");
        speaker.setLastName("007");
        speaker.setEmail("toey007@live.com");
        SaveSpeakerException thrown = assertThrows(
                SaveSpeakerException.class,
                () -> registerBusiness.register(null, speaker)
        );
        assertEquals(thrown.getMessage(), "Can't save a speaker.");
    }


}