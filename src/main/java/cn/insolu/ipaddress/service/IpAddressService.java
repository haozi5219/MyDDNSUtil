package cn.insolu.ipaddress.service;

import cn.insolu.ipaddress.entity.IpAddressEntity;

import java.util.List;
import java.util.Map;

public interface IpAddressService {
	List<Map<String, Object>> getIpAddress();
	List<Map<String, Object>> getOneIpAddress();
	int addIpAddress(IpAddressEntity ipAddressEntity);
}
