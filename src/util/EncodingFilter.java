package util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/guestbook.do")
public class EncodingFilter implements Filter {
	String env;

    public EncodingFilter() {
    	System.out.println("필터 객체 생성");
    }

    public void init(FilterConfig config) throws ServletException {
    	System.out.println("필터 객체 init");
    	env = config.getInitParameter("charset");
    }

    public void destroy() {
		System.out.println("필터 객체 destroy");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(env);
		System.out.println("필터 적용 전");
		chain.doFilter(request, response);
		System.out.println("필터 적용 후");
	}


}
