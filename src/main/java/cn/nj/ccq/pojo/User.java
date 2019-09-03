package cn.nj.ccq.pojo;

import org.springframework.data.annotation.AccessType;

import com.baomidou.mybatisplus.annotation.TableLogic;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author ZTY
 * @date 2019/8/28 10:06
 * 描述：
 */

@Data
@Accessors(chain=true)//chain决定set方法是void类型还是返回this,进行链式set方法
public class User {

    /**
     * 主键
     */
    private  Integer id;
    /**
     姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 年龄
     */
    private Integer age;
    /**
     	* 状态
     * 
     */
    @TableLogic(value="0",delval="1")
    private Integer status;
}
