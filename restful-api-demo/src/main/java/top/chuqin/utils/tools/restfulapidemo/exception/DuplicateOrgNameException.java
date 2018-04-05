package top.chuqin.utils.tools.restfulapidemo.exception;

public class DuplicateOrgNameException extends BusinessException {
    private String name;

    public DuplicateOrgNameException() {
    }

    public DuplicateOrgNameException(String name) {
        super(String.format("已存在org:[%s]", name));
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
