package by.htp.sprynchan.car_rental.web.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import by.htp.sprynchan.car_rental.resources.Resource;

public class FooterTag extends TagSupport {

	private static final long serialVersionUID = 6041995730674859548L;
	
	private static final String FOOTER = "footer";

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		
		try{
			JspWriter out = pageContext.getOut();
			out.write(Resource.getStr(FOOTER));
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}

		return SKIP_BODY;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
	 */
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	
}
