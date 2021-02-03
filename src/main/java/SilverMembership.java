public class SilverMembership extends Membership {

    private final float POINTS_SCALING_FACTOR = 1.2f;

    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        int scaledNewPoints = Math.round(newPoints * POINTS_SCALING_FACTOR);
        int newBonusPointBalance = bonusPointBalance + scaledNewPoints;
        return newBonusPointBalance;
    };

    @Override
    public String getMembershipName() {
        return "Silver";
    }

}
