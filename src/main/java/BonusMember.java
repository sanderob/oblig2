import java.time.LocalDate;

public class BonusMember {
    private int memberNumber;
    private LocalDate enrolledDate;
    private int bonusPointsBalance = 0;
    private String name;
    private String eMailAddress;
    private String password;
    private Membership membership;

    private static final int SILVER_LIMIT = 25000;
    private static final int GOLD_LIMIT = 75000;

    BonusMember(int memberNumber, LocalDate enrolledDate, int bonusPointsBalance, String name, String eMailAddress, String password) {
        this.memberNumber = memberNumber;
        this.enrolledDate = enrolledDate;
        this.bonusPointsBalance = bonusPointsBalance;
        this.name = name;
        this.eMailAddress = eMailAddress;
        this.password = password;

        this.checkAndSetMembership();
    }

    public int getMemberNumber() {
        return this.memberNumber;
    }

    public String getPassword() {
        return this.password;
    }

    public int getBonusPointsBalance() {
        return this.bonusPointsBalance;
    }

    public String getName() {
        return this.name;
    }

    public String geteMailAddress() {
        return this.eMailAddress;
    }

    public LocalDate getEnrolledDate() {
        return this.enrolledDate;
    }

    public Membership getMembership() {
        return this.membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }



    public boolean checkPassword(String password) {
        if (password.equals(this.getPassword())) {
            return true;
        }
        else {
            return false;
        }
    }

    private void checkAndSetMembership() {
        int currentMemberPoints = this.getBonusPointsBalance();

        if (currentMemberPoints >= GOLD_LIMIT) {
            this.membership = new GoldMembership();
        }
        else if(currentMemberPoints >= SILVER_LIMIT) {
            this.membership = new SilverMembership();
        }
        else {
            this.membership = new BasicMembership();
        }
    }

    public void registerBonusPoints(int newPoints) {
            this.bonusPointsBalance = this.membership.registerPoints(this.getBonusPointsBalance(), newPoints);
            this.checkAndSetMembership();
    }


}
