package test.ejb;

import javax.ejb.Remote;

@Remote
public interface CounterSingletonBeanRemote {

	public int Count();
}
