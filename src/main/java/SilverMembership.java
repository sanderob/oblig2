/**
 * A membership class representing a level of membership
 * @author Sander
 * @version 1.0.0
 */
public class SilverMembership extends Membership {

    private final float POINTS_SCALING_FACTOR = 1.2f;

    /**
     * Abstract super method given for the subclasses.
     * @param bonusPointBalance The current bonus point balance for a BonusMember
     * @param newPoints The amount of new points, before the float factor is added
     * @return The new total amount of bonus points
     */
    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        int scaledNewPoints = Math.round(newPoints * POINTS_SCALING_FACTOR);
        int newBonusPointBalance = bonusPointBalance + scaledNewPoints;
        return newBonusPointBalance;
    };

    /**
     * A method to get the level/name of the membership type.
     * @return The membership level as a String
     */
    @Override
    public String getMembershipName() {
        return "Silver";
    }

}
