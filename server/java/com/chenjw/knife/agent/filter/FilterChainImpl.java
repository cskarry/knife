package com.chenjw.knife.agent.filter;

import java.util.List;

import com.chenjw.knife.agent.event.Event;

/**
 * 过滤器链的默认实现
 * 
 * @author chenjw
 *
 */
public class FilterChainImpl implements FilterChain {
	private List<Filter> filters;
	private int index;

	public FilterChainImpl(List<Filter> filters) {
		this.filters = filters;
		this.index = 0;
	}

	@Override
	public void doFilter(Event event) throws Exception {
		if (filters == null) {
			return;
		} else if (filters.size() > index) {
			Filter f = filters.get(index);

			// Agent.println("[" + f.getClass().getSimpleName() + "] "
			// + event.getClass().getSimpleName() + " "
			// + event.getMethodName());
			this.index++;
			f.doFilter(event, this);
		}
	}
}
