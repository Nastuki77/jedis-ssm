package org.jedis.web.vo;

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
    // 用户ID
    private Long id;
    // 姓名
    private String name;
    // 所属部门
    private Long depId;
    /**
     * 登录账号
     */
    private String userName;
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

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
