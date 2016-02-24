package test.ejb;

import javax.ejb.Local;

@Local
public interface CounterBeanLocal {

	public int Count();
}
