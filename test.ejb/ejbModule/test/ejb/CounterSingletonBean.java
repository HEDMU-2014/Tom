package test.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class CounterSingletonBean implements CounterSingletonBeanRemote {

	private int counter = 0;
	
    public CounterSingletonBean() {
    }

	@Override
	public int Count() {
		counter++;
		return counter;
	}

}