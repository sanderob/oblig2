import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MemberArchiveTest {

    @Test
    void addMemberTest() {
        MemberArchive members = new MemberArchive();
        LocalDate date = LocalDate.now();
        BonusMember member = new BonusMember(6, date, 5000, "Test", "test@gmail.com", "password");
        assertTrue(members.addMember(member));
    }

    @Test
    void registerPointsTest() {
        MemberArchive members = new MemberArchive();
        LocalDate date = LocalDate.now();
        BonusMember member = new BonusMember(6, date, 5000, "Test", "test@gmail.com", "password");
        members.addMember(member);
        assertTrue(members.registerPoints(6, 1000));
        assertFalse(members.registerPoints(7, 1000));
    }

    @Test
    void findPoints() {
        MemberArchive members = new MemberArchive();
        LocalDate date = LocalDate.now();
        BonusMember member = new BonusMember(6, date, 5000, "Test", "test@gmail.com", "password");
        members.addMember(member);
        assertEquals(members.findMember(7), null);
        assertEquals(members.findPoints(6, "password"), 5000);
    }
}