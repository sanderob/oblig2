import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * The member archive holds all the bonus members. The archive provides
 * functionality for adding members to the register, looking up bonus points
 * of given members, registering new bonus points and listing all the members.
 *
 * @author Sander O. Brekke
 * @author Arne
 */
public class MemberArchive {

    // Use a HashMap, since the members have a unique member number.
    private HashMap<Integer, BonusMember> members;
    private UserInput ui = new UserInput();

    /**
     * Creates a new instance of MemberArchive.
     */
    public MemberArchive() {
        this.members = new HashMap<>();
        this.fillRegisterWithTestdata();
    }

    public void newBonusMember() {
       BonusMember member = createMember();
        addMember(member);
    }

    /**
     * Adds a new member to the register. The new member must have a member number
     * different from existing members. If not, the new member will not be added.
     *
     * @return {@code true} if the new member was added successfully,
     *         {@code false} if the new member could not be added, due to a
     *          member number that already exists.
     */
    public boolean addMember(BonusMember bonusMember) {
        boolean success;
        if (!(members.get(bonusMember.getMemberNumber()) == (null))) {
            success = false;
        }
        else {
            members.put(bonusMember.getMemberNumber(), bonusMember);
            success = true;
        }
        return success;
    }

    public BonusMember createMember() {
        int memberNumber = members.size() + 1;
        LocalDate enrolledDate = LocalDate.now();
        int bonusPointsBalance;
        String name;
        String eMailAddress;
        String password;

        System.out.println("Please enter the members full name:");
        name = ui.getString();

        System.out.println("Please enter the members E-mail:");
        eMailAddress = ui.getString();

        System.out.println("Please enter a password:");
        password = ui.getString();

        System.out.println("Please enter the entry bonus point balance");
        bonusPointsBalance = ui.getInteger();

        BonusMember member = new BonusMember(memberNumber, enrolledDate, bonusPointsBalance, name, eMailAddress, password);

        return member;
    }

    /**
     * Registers new bonuspoints to the member with the member number given
     * by the parameter {@code memberNumber}. If no member in the register
     * matches the provided member number, {@code false} is returned.
     *
     * @param memberNumber the member number to add the bonus points to
     * @param bonusPoints the bonus points to be added
     * @return {@code true} if bonuspoints were added successfully,
     *         {@code flase} if not.
     */
    public boolean registerPoints(int memberNumber, int bonusPoints) {
        boolean success = false;
        BonusMember member = findMember(memberNumber);
        if (!(member == (null))) {
            member.registerBonusPoints(bonusPoints);
            success = true;
        }
        return success;
    }

    /**
     * Lists all members to the console.
     */
    public void listAllMembers() {
        Boolean top = true;
        for (Map.Entry<Integer, BonusMember> entry : this.members.entrySet()) {
            printMemberDetails(entry.getValue(), top);
            if (top) {
                top = false;
            }
        }
    }

    public void printMemberDetails(BonusMember member, Boolean topRow) {
        if (topRow) {
            System.out.println("-----------------------");
            System.out.println("Nr. ------ Name ------ E-mail ------ Balance ------ Membership level ------ Enrolled Date");
        }
        System.out.println(member.getMemberNumber() + "     " + member.getName() + "     " + member.geteMailAddress()
                + "     " + member.getBonusPointsBalance() + "     " + member.getMembershipLevel()  + "     " + member.getEnrolledDate());
    }

    public BonusMember findMember(int memberNumber) {
        BonusMember member = this.members.get(memberNumber);
        return member;
    }


    public int findPoints(int memberNumber, String password) {
        BonusMember member = findMember(memberNumber);
        if (member.equals(null) || !member.getPassword().equals(password)) {
            return -1;
        }
        else {
            return member.getBonusPointsBalance();
        }
    }


    /**
     * Fills the register with some arbitrary members, for testing purposes.
     */
    private void fillRegisterWithTestdata() {
        BonusMember member = new BonusMember(1, LocalDate.now(), 10000, "Olsen, Ole", "ole@olsen.biz", "ok");
        addMember(member);
        member = new BonusMember(2, LocalDate.now(), 15000, "Jensen, Jens", "jens@jensen.biz", "ok");
        addMember(member);
        member = new BonusMember(3, LocalDate.now(), 5000, "Lie, Linda", "linda@lie.no", "ok");
        addMember(member);
        member = new BonusMember(4, LocalDate.now(), 30000, "Paulsen, Paul", "paul@paulsen.org", "ok");
        addMember(member);
        member = new BonusMember(5, LocalDate.now(), 75000, "Flo, Finn", "finn.flo@gmail.com", "ok");
        addMember(member);

    }


}
