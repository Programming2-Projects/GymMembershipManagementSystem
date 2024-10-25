public enum MembershipStatus {
    ACTIVE, INACTIVE;

    @Override
    public String toString() {
        switch (this) {
            case ACTIVE:
                return "Active member";
            case INACTIVE:
                return "Inactive member";       
            default:
                return super.toString();
        }      
    }

    public boolean isActive() {
        return this == ACTIVE;      
    }
}
