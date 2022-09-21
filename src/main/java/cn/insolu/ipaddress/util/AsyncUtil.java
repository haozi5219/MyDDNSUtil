package cn.insolu.ipaddress.util;

import cn.insolu.ipaddress.controller.EmailController;
import cn.insolu.ipaddress.entity.IpAddressEntity;
import cn.insolu.ipaddress.service.EmailService;
import cn.insolu.ipaddress.service.IpAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Component
public class AsyncUtil {

    @Autowired
    private IpAddressService ipAddressService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmailController emailController;

    @Async
    public void Asynchronous(){
        System.out.println("任务执行时间：" + LocalDateTime.now());
        List<Map<String, Object>> mapList1 = this.emailService.getEmail();
        String[] strings = new String[mapList1.size()];
        for (int i = 0 ; i< mapList1.size(); i++){
            strings[i]=mapList1.get(i).get("email").toString();
        }

        List<Map<String, Object>> mapList= this.ipAddressService.getOneIpAddress();

        for (int j = 0; j < mapList.size(); j++){
            List<IpAddressEntity> ipAddressEntityList = new GetAddressUtil().getIpAddress(mapList.get(j).get("ip").toString());
            while (ipAddressEntityList.size()>1){
                try {
                    Thread.sleep(60);
                    ipAddressEntityList = new GetAddressUtil().getIpAddress(mapList.get(j).get("ip").toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0 ; i <ipAddressEntityList.size(); i++ ){
                this.ipAddressService.addIpAddress(ipAddressEntityList.get(i));
                emailController.sendTemplateEmail(mapList.get(0).get("ip").toString(),strings,ipAddressEntityList.get(i));
            }
            return ;
        }
    }

}