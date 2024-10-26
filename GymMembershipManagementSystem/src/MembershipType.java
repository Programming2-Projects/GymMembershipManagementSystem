public enum MembershipType {
    MONTHLY, // 1 month validity
    YEARLY, // 1 year validity
    PREMIUM; // 1 month validity  + extra benefits

    @Override
    public String toString() {
        switch (this) {
            case MONTHLY:
                return "Monthly subscribtion";
            case YEARLY:
                return "Yearly subscribtion";
            case PREMIUM:
                return "Premium subscribtion";   
            default:
                return super.toString();
        }      
    }

}
