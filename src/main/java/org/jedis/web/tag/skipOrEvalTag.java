package org.jedis.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Created by Administrator on 2016/10/12.
 */
public class skipOrEvalTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        String name = pageContext.getRequest().getParameter("name");
        if(name!=null && name.equals("Nastuki")){
            return EVAL_BODY_INCLUDE;
        }else{
            return SKIP_BODY;
        }
    }

}
