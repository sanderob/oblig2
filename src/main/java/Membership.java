public abstract class Membership {

    BasicMembership basicMembership = new BasicMembership();
    SilverMembership silverMembership = new SilverMembership();
    GoldMembership goldMembership = new GoldMembership();

    public abstract int registerPoints(int bonusPointBalance, int newPoints);

    public abstract String getMembershipName();
}
