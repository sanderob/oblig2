public abstract class Membership {

    public abstract int registerPoints(int bonusPointBalance, int newPoints);
    public abstract String getMembershipName();


    public static Membership createGMembership() {
        return new GoldMembership();
    }

    public static Membership createSMembership() {
        return new SilverMembership();
    }

    public static Membership createBMembership() {
        return new BasicMembership();
    }

}
