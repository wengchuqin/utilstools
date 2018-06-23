package top.chuqin.utils.tools.json;

public class CommonDictPo extends BasePo<Long> {
    private String categoryCode;
    private String categoryName;

    public CommonDictPo() {
        super();
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CommonDictPo{" +
                "categoryCode='" + categoryCode + '\'' +
                ", categoryName='" + categoryName + '\'' +
                "} " + super.toString();
    }
}
