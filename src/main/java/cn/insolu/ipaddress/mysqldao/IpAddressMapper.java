package cn.insolu.ipaddress.mysqldao;

import cn.insolu.ipaddress.entity.IpAddressEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IpAddressMapper {
	List<Map<String, Object>> getIpAddress();
	List<Map<String, Object>> getOneIpAddress();
	int addIpAddress(IpAddressEntity ipAddressEntity);
}
