/**
 * The class representing a single bonus member, used in the bonus member archive
 * @author Sander
 * @version 1.0.0
 */

import java.time.LocalDate;

public class BonusMember {

    private int memberNumber;
    private LocalDate enrolledDate;
    private int bonusPointsBalance = 0;
    private String name;
    private String eMailAddress;
    private String password;
    private Membership membership;

    private static final int SILVER_LIMIT = 25000;
    private static final int GOLD_LIMIT = 75000;

    /**
     * Creates a new instance of a BonusMember
     * @param memberNumber The memberNumber, used for reference in the HashMap-archive
     * @param enrolledDate The date of the enrollment. To be used in later development of bonus level functionality
     * @param bonusPointsBalance The current number of bonus points beloning to the member
     * @param name The name of the bonus member
     * @param eMailAddress The emailaddress of the bonus member
     * @param password The password of the bonus member
     */
    BonusMember(int memberNumber, LocalDate enrolledDate, int bonusPointsBalance, String name, String eMailAddress, String password) {
        this.memberNumber = memberNumber;
        this.enrolledDate = enrolledDate;
        this.bonusPointsBalance = bonusPointsBalance;
        this.name = name;
        this.eMailAddress = eMailAddress;
        this.password = password;

        this.checkAndSetMembership();
    }

    /**
     *
     * @return The member number of the referenced member object
     */
    public int getMemberNumber() {
        return this.memberNumber;
    }

    /**
     *
     * @return The password of the referenced member object
     */
    public String getPassword() {
        return this.password;
    }

    /**
     *
     * @return The bonus point balance of the referenced member object
     */
    public int getBonusPointsBalance() {
        return this.bonusPointsBalance;
    }

    /**
     *
     * @return The name of the referenced member object
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return the emailaddress of the referenced member object
     */
    public String geteMailAddress() {
        return this.eMailAddress;
    }

    /**
     *
     * @return The date of enrollment of the referenced member object
     */
    public LocalDate getEnrolledDate() {
        return this.enrolledDate;
    }

    /**
     *
     * @return The membership level of the referenced member object, Object
     */
    public Membership getMembership() {
        return this.membership;
    }

    /**
     *
     * @param newMembership the membership level you want to set for the bonus member
     */
    public void setMembership(Membership newMembership) {
        this.membership = newMembership;
    }

    /**
     *
     * @param password
     * @return {@code true} if the checked password is correct
     *          {@code false} if the checked password is incorrect
     */
    public boolean checkPassword(String password) {
        if (password.equals(this.getPassword())) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Checks the bonus point balance and the current membership level, adjusting the membership level if necessary
     */
    private void checkAndSetMembership() {
        int currentMemberPoints = this.getBonusPointsBalance();

        if (currentMemberPoints >= GOLD_LIMIT) {
            this.setMembership(this.membership.createMembership());
        }
        else if(currentMemberPoints >= SILVER_LIMIT) {
            this.setMembership(this.membership.createMembership());
        }
        else {
            this.setMembership(this.membership.createMembership());
        }
    }

    /**
     * Registers new points to a member, before checking the membershiplevel and adjusting i necessary,
     * using the checkAndSetMembership method
     * @param newPoints The amount of new points given to a member
     */
    public void registerBonusPoints(int newPoints) {
            this.bonusPointsBalance = this.membership.registerPoints(this.getBonusPointsBalance(), newPoints);
            this.checkAndSetMembership();
    }


}
