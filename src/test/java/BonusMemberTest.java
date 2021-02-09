import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusMemberTest {

    @Test
    @DisplayName("Testing the use of the constructor and the get-methods.")
    void constructorTest() {
        LocalDate date = LocalDate.now();
        BonusMember member = new BonusMember(1, date, 5000, "Test", "test@gmail.com", "password");
        assertEquals(1, member.getMemberNumber());
        assertEquals(date, member.getEnrolledDate());
        assertEquals(5000, member.getBonusPointsBalance());
        assertEquals("Test", member.getName());
        assertEquals("test@gmail.com", member.geteMailAddress());
        assertEquals("password", member.getPassword());
    }

    @Test
    @DisplayName("Testing the checkPassword-method")
    void checkPasswordTest() {
        LocalDate date = LocalDate.now();
        BonusMember member = new BonusMember(1, date, 5000, "Test", "test@gmail.com", "password");
        assertTrue(member.checkPassword("password"));
        assertFalse(member.checkPassword("Password"));
    }

    @Test
    void checkAndSetMembershipAndRegisterBonusPointsTest() {
        LocalDate date = LocalDate.now();
        BonusMember member = new BonusMember(1, date, 5000, "Test", "test@gmail.com", "password");
        assertTrue(member.getMembership().getMembershipName().equals("Basic"));
        member.registerBonusPoints(21000);
        assertEquals(member.getMembership().getMembershipName(), ("Silver"));
        member.registerBonusPoints(60000);
        assertEquals(member.getMembership().getMembershipName(), ("Gold"));
    }
}