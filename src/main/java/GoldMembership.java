/**
 * A membership class representing a level of membership
 * @author Sander
 * @version 1.0.0
 */
public class GoldMembership extends Membership {

    private final float POINTS_SCALING_FACTOR_LEVEL_1 = 1.3f;
    private final float POINTS_SCALING_FACTOR_LEVEL_2 = 1.5f;

    /**
     * Abstract super method given for the subclasses.
     * @param bonusPointBalance The current bonus point balance for a BonusMember
     * @param newPoints The amount of new points, before the float factor is added
     * @return The new total amount of bonus points
     */
    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        int scaledNewPoints;
        if (bonusPointBalance > 90000) {
            scaledNewPoints = Math.round(newPoints * POINTS_SCALING_FACTOR_LEVEL_1);
        }
        else {
            scaledNewPoints = Math.round(newPoints * POINTS_SCALING_FACTOR_LEVEL_2);
        }
        int newBonusPointBalance = bonusPointBalance + scaledNewPoints;
        return newBonusPointBalance;
    };

    /**
     * A method to get the level/name of the membership type.
     * @return The membership level as a String
     */
    @Override
    public String getMembershipName() {
        return "Gold";
    }
}
