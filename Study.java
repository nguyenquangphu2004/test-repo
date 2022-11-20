public enum Study {
    F("TRƯỢT MÔN"),
    D("YẾU"),
    C("TRUNG BÌNH"),
    B("KHÁ"),
    A("GIỎI"),
    A_PLUS("XUẤT SẮC");

    Study(String value) {
        this.value = value;
    }
    private String value;


    public String getValue() {
        return value;
    }
}
