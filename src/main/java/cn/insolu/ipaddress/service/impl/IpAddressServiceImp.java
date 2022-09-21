package cn.insolu.ipaddress.service.impl;

import cn.insolu.ipaddress.entity.IpAddressEntity;
import cn.insolu.ipaddress.mysqldao.IpAddressMapper;
import cn.insolu.ipaddress.service.IpAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("ipAddressService")
public class IpAddressServiceImp implements IpAddressService {
	@Autowired
	private IpAddressMapper ipAddressMapper;

	@Override
	public List<Map<String, Object>> getIpAddress() {
		return this.ipAddressMapper.getIpAddress();
	}
	@Override
	public List<Map<String, Object>> getOneIpAddress() {
		return this.ipAddressMapper.getOneIpAddress();
	}
	public int addIpAddress(IpAddressEntity ipAddressEntity) {
		return this.ipAddressMapper.addIpAddress(ipAddressEntity);
	}
}
