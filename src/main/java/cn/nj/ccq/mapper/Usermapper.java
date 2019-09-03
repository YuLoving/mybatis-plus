package cn.nj.ccq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.nj.ccq.pojo.User;

//mybatis plus必须继承BaseMapper<>

public interface Usermapper extends  BaseMapper<User>{
	
	
	
	
	
	
	//分页查询
	IPage<User>  getall(Page<User> page);
}
