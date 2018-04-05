package top.chuqin.utils.tools.restfulapidemo.enumeration;

public enum  ResourceEnum{
    ORGS(0, "orgs"),
    EMPLOYEES(1, "employees");

    private final int code;
    private final String name;

    ResourceEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
