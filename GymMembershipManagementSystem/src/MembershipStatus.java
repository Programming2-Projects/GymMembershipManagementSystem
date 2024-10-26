public enum MembershipStatus {
    ACTIVE, CANCELED;

    @Override
    public String toString() {
        switch (this) {
            case ACTIVE:
                return "Active membership";
            case CANCELED:
                return "Canceled membership";       
            default:
                return super.toString();
        }      
    }

    public boolean isActive() {
        return this == ACTIVE;      
    }
}
