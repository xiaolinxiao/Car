package com.lx.car.Bean;

/**
 * Created by lx on 2016/9/30.
 */
public class ProjectBean {
    private String time;//发布时间
    private String cycle;//周期
    private String address;//地址
    private String workerNum;//所需工人数量
    private String carNum;//所需车辆数量

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkerNum() {
        return workerNum;
    }

    public void setWorkerNum(String workerNum) {
        this.workerNum = workerNum;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }
}
