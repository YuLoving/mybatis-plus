package cn.nj.ccq.Enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

//mybatis plus 通用枚举实现 IEnum 接口
public enum AgeEnum implements IEnum<Integer> {
	ONE(1,"一岁"),
	TWO(2,"二岁"),
	THREE(3,"三岁");
	
	private int value;
	private String desc;
	


	//构造函数
	private AgeEnum(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}


	@Override
	public Integer getValue() {
		
		return this.value;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}

	
}
