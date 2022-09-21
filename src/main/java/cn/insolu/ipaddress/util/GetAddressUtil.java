package cn.insolu.ipaddress.util;

import cn.insolu.ipaddress.entity.IpAddressEntity;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GetAddressUtil {

    public List<IpAddressEntity> getIpAddress(String ip){

//        JSONObject cipJsonObject = new GetAddressUtil().cipGetAddress();
//        JSONObject ipipJsonObject = new GetAddressUtil().ipipGetAddress();
        JSONObject ifcinfigIoJsonObject = new GetAddressUtil().ifconfigIoGetAddress();
        JSONObject ifconfigMeJsonObject = new GetAddressUtil().ifconfigMeGetAddress();
        JSONObject ipinfoJsonObject = new GetAddressUtil().ipinfoGetAddress();
        IpAddressEntity cipIpAddressEntity = new IpAddressEntity();
        IpAddressEntity ipipIpAddressEntity = new IpAddressEntity();
        IpAddressEntity ifconfigIoIpAddressEntity = new IpAddressEntity();
        IpAddressEntity ifconfigMeIpAddressEntity = new IpAddressEntity();
        IpAddressEntity ipinfoIpAddressEntity = new IpAddressEntity();
        List<IpAddressEntity> ipAddressEntityList=new ArrayList<>();

//        if ( cipJsonObject.get("ip") != null && !cipJsonObject.get("ip").equals(ip) ){
//            cipIpAddressEntity.setIpAddress(cipJsonObject.get("ip").toString());
//            cipIpAddressEntity.setSource("cip.cc");
//            ipAddressEntityList.add(cipIpAddressEntity);
//        }
//        if ( ipipJsonObject.get("ip") != null && !ipipJsonObject.get("ip").equals(ip) ){
//            ipipIpAddressEntity.setIpAddress(ipipJsonObject.get("ip").toString());
//            ipipIpAddressEntity.setSource("ipip.net");
//            ipAddressEntityList.add(ipipIpAddressEntity);
//        }
        if ( ifcinfigIoJsonObject.get("ip") != null && !ifcinfigIoJsonObject.get("ip").equals(ip) ){
            ifconfigIoIpAddressEntity.setIpAddress(ifcinfigIoJsonObject.get("ip").toString());
            ifconfigIoIpAddressEntity.setSource("ifconfig.io");
            ipAddressEntityList.add(ifconfigIoIpAddressEntity);
        }
        if ( ifconfigMeJsonObject.get("ip_addr") != null && !ifconfigMeJsonObject.get("ip_addr").equals(ip) ){
            ifconfigMeIpAddressEntity.setIpAddress(ifconfigMeJsonObject.get("ip_addr").toString());
            ifconfigMeIpAddressEntity.setSource("ifconfig.me");
            ipAddressEntityList.add(ifconfigMeIpAddressEntity);
        }
        if ( ipinfoJsonObject.get("ip") != null && !ipinfoJsonObject.get("ip").equals(ip) ){
            ipinfoIpAddressEntity.setIpAddress(ipinfoJsonObject.get("ip").toString());
            ipinfoIpAddressEntity.setSource("ipinfo.io");
            ipAddressEntityList.add(ipinfoIpAddressEntity);
        }
        List<IpAddressEntity> list = new GetAddressUtil().removeDuplicationBy2For(ipAddressEntityList);

        return list;
    }

    private List<IpAddressEntity> removeDuplicationBy2For(List<IpAddressEntity> list) {
        for (int i=0;i<list.size();i++)
        {
            for (int j=i+1 ; j<list.size() ; j++)
            {
                if(list.get(i).getIpAddress().equals(list.get(j).getIpAddress())){
                    list.remove(j);
                    j--;
                }
            }
        }
        return list;
    }


//    public JSONObject cipGetAddress(){
//        String[] cmds = {"curl","cip.cc"};
//        String data = new GetAddressUtil().getAddress(cmds).toString();
//
//        String[] temp;
//        String delimeter = "\n";
//        temp = Arrays.stream(data.split(delimeter)).filter(s -> !"".equals(s)).toArray(String[]::new);
//        Map<String,Object> map =new HashMap<>();
//        for(int i = 0; i < temp.length; i++){
//
//            String[] temp1;
//            String delimeter1 = "\t: ";
//            temp1 = temp[i].split(delimeter1);
//            for(int j =0; j < temp1.length ; j++){
//                if (j==1){
//                    if (i==0) {
//                        map.put("ip",temp1[j]);
//                    } else if (i == 1) {
//                        map.put("address",temp1[j]);
//                    } else if (i == 2) {
//                        map.put("operator",temp1[j]);
//                    } else if (i == 3) {
//                        map.put("address1",temp1[j]);
//                    } else if (i == 4) {
//                        map.put("address2",temp1[j]);
//                    } else if (i == 5) {
//                        map.put("url",temp1[j]);
//                    }
//                }
//            }
//        }
//        JSONObject jsonObject = JSONObject.fromObject(map);
//        return jsonObject;
//    }
//
//    public JSONObject ipipGetAddress(){
//        String[] cmds = {"curl","myip.ipip.net/json"};
//        JSONObject jsonObject = JSONObject.fromObject(new GetAddressUtil().getAddress(cmds).toString());
//        JSONObject jsonObject1 = JSONObject.fromObject(jsonObject.get("data").toString());
//        return jsonObject1;
//    }

    public JSONObject ipinfoGetAddress(){
        String[] cmds = {"curl","ipinfo.io/json?token=f99c591f753580"};
        String result = new GetAddressUtil().getAddress(cmds).toString();
        System.out.println(result);
        JSONObject jsonObject = JSONObject.fromObject(result);

        return jsonObject;
    }

    public JSONObject ifconfigMeGetAddress(){
        String[] cmds = {"curl","ifconfig.me/all.json"};
        String result = new GetAddressUtil().getAddress(cmds).toString();
        System.out.println(result);
        JSONObject jsonObject = JSONObject.fromObject(result);
        return jsonObject;
    }

    public JSONObject ifconfigIoGetAddress(){
        String[] cmds = {"curl","ifconfig.io/all.json"};
        String result = new GetAddressUtil().getAddress(cmds).toString();
        System.out.println(result);
        JSONObject jsonObject = JSONObject.fromObject(result);
        return jsonObject;
    }

    private StringBuilder getAddress(String[] cmds){
        ProcessBuilder process = new ProcessBuilder(cmds);
        try {
            Process p = process.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line ;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
            return builder;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}