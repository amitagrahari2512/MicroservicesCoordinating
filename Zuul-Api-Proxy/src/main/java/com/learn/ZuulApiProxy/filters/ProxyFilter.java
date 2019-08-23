package com.learn.ZuulApiProxy.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class ProxyFilter extends ZuulFilter{
	
	@Override
	public Object run() throws ZuulException {
		System.out.println("Calling a filter!");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		
		boolean isMobile = false;
		RequestContext ctx = RequestContext.getCurrentContext();
		String param= ctx.getRequest().getParameter("source");
		if(param != null && param.equalsIgnoreCase("mobile"))
		{
			isMobile = true;
		}
		return isMobile;
	}
	

	@Override
	public int filterOrder() {
		return 1;
	}


	@Override
	public String filterType() {
		return "pre";
	}

}
