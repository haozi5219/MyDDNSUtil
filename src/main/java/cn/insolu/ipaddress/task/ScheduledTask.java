package cn.insolu.ipaddress.task;

import cn.insolu.ipaddress.controller.EmailController;
import cn.insolu.ipaddress.entity.IpAddressEntity;
import cn.insolu.ipaddress.service.EmailService;
import cn.insolu.ipaddress.service.IpAddressService;
import cn.insolu.ipaddress.util.AsyncUtil;
import cn.insolu.ipaddress.util.GetAddressUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Component
public class ScheduledTask {
    @Autowired
    private AsyncUtil asyncUtil;

    @Scheduled(fixedRate = 60000)
    public void scheduledTask() {
        asyncUtil.Asynchronous();
    }
}

