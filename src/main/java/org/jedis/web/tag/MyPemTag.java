package org.jedis.web.tag;

/**
 * Created by Nastuki on 2016/10/12.
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.IOException;
import java.io.Writer;
import org.jedis.entity.Allows;
import org.jedis.web.vo.utilsVo.LoginInfo;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyPemTag extends SimpleTagSupport {
    private String module;
    private String value;

    public MyPemTag() {
    }

    public void doTag() throws JspException, IOException {
        LoginInfo login = (LoginInfo)this.getJspContext().findAttribute("current_ssologin_user");
        if(login != null && login.getAllows().contains(new Allows(this.module, this.value))) {
            this.getJspBody().invoke((Writer)null);
        }

    }

    public String getModule() {
        return this.module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
