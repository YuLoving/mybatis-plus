package cn.nj.ccq.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.nj.ccq.mapper.Usermapper;
import cn.nj.ccq.pojo.User;

import cn.nj.ccq.service.UserService;

@RestController
public class Usercontrller {

	

	private UserService userService;
	private Usermapper usermapper;
	
	
	//通过构造函数注入依赖
	@Autowired
	public Usercontrller(UserService userService,Usermapper usermapper) {
		
		this.userService=userService;
		this.usermapper=usermapper;
		
	}
	
	//逻辑删除
	@PostMapping("/luoji")
	public Object luoji(Integer id) {
		int byId = usermapper.deleteById(id);
		System.out.println(byId);
		return byId;
		
	}
	
	
	//根据MAP删除
	
	@PostMapping("/deletebymap")
	public Object deletebymap(Integer id) {
		User user = usermapper.selectById(id);
		
		Map<String, Object> map = new HashMap<>(2);
		
		map.put("name", user.getName());
		map.put("sex", user.getSex());
		
		int i = usermapper.deleteByMap(map);
		
		
		return i;
		
	}
	
	
	
	
	
	
	//添加一条记录
	@PostMapping("addone")
	public Object addone() {
		User user = new User();
		user.setId(12).setAge(22).setName("小医仙").setSex("女");
		int insert = usermapper.insert(user);
		return insert;
		
	}
	
	
	
	
	@GetMapping("/list")
	public Object getlist() {
		List<User> list = usermapper.selectList(null);
		return list;
	}
	
	//mybatis plus 自带的批量添加
	@PostMapping("/bitchadd")
	public Object bitchadd(){
		User user1 = new User();
		user1.setAge(30).setName("周琦").setSex("男").setId(13);
		User user2 = new User();
		user2.setAge(40).setName("姚明").setSex("男").setId(14);
		User user3 = new User();
		user3.setAge(50).setName("科比").setSex("男").setId(15);
		
		
		
		List<User> list = new ArrayList<>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		
		
		boolean b = userService.saveBatch(list);
		
	
		String a= (b==true)?"批量添加成功":"批量添加失败";
		
		return a;
		
	}
	
	//mybatis plus 自带的批量delete
		@SuppressWarnings("unchecked")
		@PostMapping("/bitchdel")
		public Object bitchdel(){
		/*	User user1 = new User();
			user1.setAge(30).setName("周琦").setSex("男");
			User user2 = new User();
			user2.setAge(40).setName("姚明").setSex("男");
			User user3 = new User();
			user3.setAge(50).setName("科比").setSex("男");
			*/
			
			
			List list = new ArrayList<>();
			list.add(1);
			list.add(2);
			list.add(3);
			
			
			
			int i = usermapper.deleteBatchIds(list);
			
			String a= (i>0)?"批量删除成功":"批量删除失败";
			System.out.println("批量执行了几条"+i);
			return a;
			
		}
		
		//mybatis plus 自带的批量update
		@PostMapping("/bitchupa")
		public Object bitchupd(){
			User user1 = new User();
			user1.setAge(26).setName("尹旺").setSex("男").setId(6);
			User user2 = new User();
			user2.setAge(25).setName("俊男").setSex("男").setId(7);
			
			
			
			
			List<User> list = new ArrayList<>();
			list.add(user1);
			list.add(user2);
			
			boolean b = userService.updateBatchById(list);
				
			String a= (b==true)?"批量添加成功":"批量添加失败";
			
			return a;
			
		}
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/get")
	public Object get(int a,int b) {
		Page<User> page = new Page<>(a,b);
		IPage<User> fenye = userService.fenye(a, b);
		//IPage<User> getall = usermapper.getall(page);
		System.out.println("每次分页的结果集"+fenye.getRecords());
		System.out.println("总条数："+fenye.getTotal());
		return fenye;
	}
	
}
