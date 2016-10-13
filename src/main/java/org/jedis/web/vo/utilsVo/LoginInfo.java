package org.jedis.web.vo.utilsVo;

/**
 * Created by Nastuki on 2016/10/12.
 */


import org.jedis.entity.Allows;

import java.util.ArrayList;
import java.util.List;

/**
 * 单点登录信息
 *
 * @author jony
 *
 */
public class LoginInfo {

    /*
    * ID
    * */
    private Long id;

    /*
    * 名称
    * */
    private String name;

    /*
    * email邮箱
    * */
    private String email;


    /**
     * 可允许访问的权限
     */
    private List<Allows> allows = new ArrayList<Allows>();

    public Long getId() {
        return id;
    }

    public List<Allows> getAllows() {
        return allows;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setAllows(List<Allows> allows) {
        this.allows = allows;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
