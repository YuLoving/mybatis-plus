package cn.nj.ccq.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import cn.nj.ccq.pojo.User;


//mybatis plus 必须继承IService<T>
public interface UserService extends IService<User>{
	
	IPage<User> fenye(int a,int b);
}
