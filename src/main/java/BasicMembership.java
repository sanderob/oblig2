public class BasicMembership extends Membership {

    private final float POINTS_SCALING_FACTOR = 1.2f;

    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        int newBonusPointBalance = bonusPointBalance + newPoints;
        return newBonusPointBalance;
    };

    @Override
    public String getMembershipName() {
        return "Basic";
    }
}
