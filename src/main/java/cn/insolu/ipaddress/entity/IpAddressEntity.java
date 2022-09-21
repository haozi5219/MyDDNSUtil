package cn.insolu.ipaddress.entity;

import java.sql.Time;

public class IpAddressEntity {
    int id;
    String ipAddress;
    Time time;
    String source;

    public int getId() {
        return id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Time getTime() {
        return time;
    }

    public String getSource() {
        return source;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
