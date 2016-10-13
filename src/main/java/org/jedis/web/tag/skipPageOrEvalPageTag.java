package org.jedis.web.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by Administrator on 2016/10/12.
 */
public class skipPageOrEvalPageTag extends TagSupport {

    @Override
    public int doEndTag() throws JspException {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        String referer = request.getHeader("referer");
        String url = "http://"+request.getServerName();
        if(referer!=null && referer.startsWith(url)){
            return EVAL_PAGE;
        }else{
            try {
                pageContext.getOut().print("不能访问！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return SKIP_PAGE;
    }

}
