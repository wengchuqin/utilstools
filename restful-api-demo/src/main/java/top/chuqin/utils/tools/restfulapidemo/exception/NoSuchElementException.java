package top.chuqin.utils.tools.restfulapidemo.exception;

public class NoSuchElementException extends BusinessException{
    private String resource;
    private String id;

    public String getResource() {
        return resource;
    }

    public String getId() {
        return id;
    }

    public NoSuchElementException(String resource, String id) {
        super(String.format("在资源[%s]中找不到id为[]的实体", resource, id));
        this.resource = resource;
        this.id = id;
    }

    public NoSuchElementException(String resource, int id) {
        super(String.format("在资源[%s]中找不到id为[%d]的实体", resource, id));
        this.resource = resource;
        this.id = String.valueOf(id);
    }
}
