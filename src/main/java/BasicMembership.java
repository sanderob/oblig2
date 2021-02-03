public class BasicMembership extends Membership {


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
