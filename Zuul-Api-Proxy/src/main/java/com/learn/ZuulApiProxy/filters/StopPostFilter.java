package com.learn.ZuulApiProxy.filters;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class StopPostFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		Instant stop = Instant.now();
		//get Start value
		RequestContext ctx = RequestContext.getCurrentContext();
		Instant start = (Instant)ctx.get("startTime");
		long secondDifferences = ChronoUnit.MILLIS.between(start, stop);
		System.out.println("Call took sec "+secondDifferences + " milliseconds");
		return null;
		
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1	;
	}

}
