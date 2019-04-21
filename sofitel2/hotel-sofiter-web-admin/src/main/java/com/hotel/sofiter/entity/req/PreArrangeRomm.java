package com.hotel.sofiter.entity.req;

public class PreArrangeRomm {
    private String id;

    private Integer success;


    @Override
    public String toString() {
        return "PreArrangeRomm{" +
                "id='" + id + '\'' +
                ", success=" + success +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }
}
