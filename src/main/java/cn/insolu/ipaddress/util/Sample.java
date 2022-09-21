// This file is auto-generated, don't edit it. Thanks.
package cn.insolu.ipaddress.util;

import com.aliyun.alidns20150109.models.*;
import com.aliyun.tea.*;
import com.aliyun.teaopenapi.models.*;

public class Sample {

    /**
     * 使用AK&SK初始化账号Client
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    public static com.aliyun.alidns20150109.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "alidns.cn-hangzhou.aliyuncs.com";
        return new com.aliyun.alidns20150109.Client(config);
    }

    public  String aliyunDDNS(String ipAddress) throws Exception {
        com.aliyun.alidns20150109.Client client = Sample.createClient("", "");
        UpdateDomainRecordRequest updateDomainRecordRequest = new UpdateDomainRecordRequest()
                .setRR("@")
                .setType("a")
                .setRecordId("")
                .setValue(ipAddress);
        UpdateDomainRecordResponse resp = client.updateDomainRecord(updateDomainRecordRequest);
        com.aliyun.teaconsole.Client.log(com.aliyun.teautil.Common.toJSONString(TeaModel.buildMap(resp)));
        return "aa";
    }
}
