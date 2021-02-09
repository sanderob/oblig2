/**
 * A simple super class for the (currently) three levels of membership, extending and inheriting methods.
 * @author Sander
 * @version 1.0.0
 */
public abstract class Membership {

    /**
     * Abstract super method given for the subclasses.
     * @param bonusPointBalance The current bonus point balance for a BonusMember
     * @param newPoints The amount of new points, before the float factor is added
     * @return The new total amount of bonus points
     */
    public abstract int registerPoints(int bonusPointBalance, int newPoints);

    /**
     * A method to get the level/name of the membership type.
     * @return The membership level as a String
     */
    public abstract String getMembershipName();

    public Membership createMembership(/*String membershipType*/) {

        return new BasicMembership();

       /* if (membershipType.equals("basic")) {
            return new BasicMembership();
        }
        else if (membershipType == "silver") {
            return new SilverMembership();
        }
        else {
            return new GoldMembership();
        }*/
    }

}
