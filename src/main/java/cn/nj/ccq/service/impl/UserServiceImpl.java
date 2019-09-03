package cn.nj.ccq.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.nj.ccq.mapper.Usermapper;
import cn.nj.ccq.pojo.User;
import cn.nj.ccq.service.UserService;




//实现接口的同时必须继承extends ServiceImpl<XXXmapper, XXX>
@Service
public class UserServiceImpl extends ServiceImpl<Usermapper, User> implements UserService{

	@Autowired
	private Usermapper usermapper;
	
	
	@Override
	public IPage<User> fenye(int a, int b) {
		//设置分页的当前页 和 每页大小
		Page<User> page = new Page<>(a,b);
		//开始分页
		IPage<User> iPage = usermapper.getall(page);
		// TODO Auto-generated method stub
		return iPage;
	}



}
