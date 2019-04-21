package com.hotel.sofiter.entity.resp.stayregister;

import java.util.List;

public class RoomSetResp<T> {

    List<T> result;

    public RoomSetResp(List<T> result) {
        this.result = result;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
