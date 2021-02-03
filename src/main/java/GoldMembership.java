public class GoldMembership extends Membership {

    private final float POINTS_SCALING_FACTOR_LEVEL_1 = 1.3f;
    private final float POINTS_SCALING_FACTOR_LEVEL_2 = 1.5f;

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

    @Override
    public String getMembershipName() {
        return "Gold";
    }
}
