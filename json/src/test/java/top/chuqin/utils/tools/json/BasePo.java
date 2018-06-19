package top.chuqin.utils.tools.json;

import java.io.Serializable;

public class BasePo <T extends Serializable> {
    private T id;

    private Long updateTime;

    private Boolean deleted;

    public BasePo() {
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "BasePo{" +
                "id=" + id +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}

