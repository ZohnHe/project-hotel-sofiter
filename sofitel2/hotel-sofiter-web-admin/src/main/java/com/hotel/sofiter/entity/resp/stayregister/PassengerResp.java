package com.hotel.sofiter.entity.resp.stayregister;

import java.util.List;

public class PassengerResp<T> {

    List<T> result;

    public PassengerResp(List<T> result) {
        this.result = result;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
