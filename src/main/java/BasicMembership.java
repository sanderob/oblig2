/**
 * A membership class representing a level of membership
 * @author Sander
 * @version 1.0.0
 */
public class BasicMembership extends Membership {

    /**
     * Abstract super method given for the subclasses.
     * @param bonusPointBalance The current bonus point balance for a BonusMember
     * @param newPoints The amount of new points, before the float factor is added
     * @return The new total amount of bonus points
     */
    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        int newBonusPointBalance = bonusPointBalance + newPoints;
        return newBonusPointBalance;
    };

    /**
     * A method to get the level/name of the membership type.
     * @return The membership level as a String
     */
    @Override
    public String getMembershipName() {
        return "Basic";
    }
}
