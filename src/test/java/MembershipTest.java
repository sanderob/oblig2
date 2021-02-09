import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class MembershipTest {

    @Test
    void registerPointsTest() {
        LocalDate date = LocalDate.now();
        BonusMember member = new BonusMember(1, date, 5000, "Test", "test@gmail.com", "password");
        assertEquals(member.getMembership().getMembershipName(), "Basic");
        member.registerBonusPoints(25000);
        assertEquals(member.getMembership().getMembershipName(), "Silver");
        member.registerBonusPoints(45000);
        assertEquals(member.getMembership().getMembershipName(), "Gold");
        System.out.println(member.getBonusPointsBalance());
        member.registerBonusPoints((6001));
        member.registerBonusPoints(10);
    }


}