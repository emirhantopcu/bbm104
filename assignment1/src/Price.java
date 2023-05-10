public class Price {
    private String product;
    private String membershipType;
    private String startDate;
    private String endDate;
    private String value;

    public Price(String product, String membershipType, String startDate, String endDate, String value) {
        this.product = product;
        this.membershipType = membershipType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.value = value;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

