package cn.insolu.ipaddress.service.impl;

import cn.insolu.ipaddress.entity.IpAddressEntity;
import cn.insolu.ipaddress.mysqldao.EmailMapper;
import cn.insolu.ipaddress.mysqldao.IpAddressMapper;
import cn.insolu.ipaddress.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("EmailService")
public class EmailServiceImp implements EmailService {
	@Autowired
	private cn.insolu.ipaddress.mysqldao.EmailMapper EmailMapper;

	@Override
	public List<Map<String, Object>> getEmail() {
		return this.EmailMapper.getEmail();
	}

}
