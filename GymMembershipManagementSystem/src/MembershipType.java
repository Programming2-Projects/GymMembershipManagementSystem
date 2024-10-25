public enum MembershipType {
    MONTHLY, // 1 month validity
    QUARTERLY, // 3 month validity
    ANNUAL, // 1 year validity
    PREMIUM, // 1 month validity  + extra benefits
    LIFETIME; // Lifetime validity

    @Override
    public String toString() {
        switch (this) {
            case MONTHLY:
                return "Monthly subscribtion";
            case QUARTERLY:
                return "Quarterly subscribtion";
            case ANNUAL:
                return "Annual subscribtion";
            case PREMIUM:
                return "Premium subscribtion";
            case LIFETIME:
                return "Lifetime subscribtion";       
            default:
                return super.toString();
        }      
    }

}
