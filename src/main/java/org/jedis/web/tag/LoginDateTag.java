package org.jedis.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/10/12.
 */
public class LoginDateTag extends TagSupport {

    private String value = "";

    private String type = "";


    public void setValue(String value) {
      this.value = value;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int doStartTag() throws JspException {
        SimpleDateFormat sdf = null;
        if ("both".equals(this.type.toLowerCase())) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } else if ("date".equals(this.type.toLowerCase())) {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        }
        String dateStr = "";

        if (value != null || value.equals("")) {
            dateStr = sdf.format(new Date());
        } else {
            try {
                dateStr = sdf.format(sdf.parse(this.value));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        try {
            pageContext.getOut().print(dateStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }


}
