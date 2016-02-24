package test.ejb;

import java.util.concurrent.atomic.AtomicInteger;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

@Stateful
@LocalBean
public class CounterBean implements CounterBeanLocal {
	
	private AtomicInteger counter = new AtomicInteger(0);

    public CounterBean() {
    }

	@Override
	public int Count() {
		return counter.incrementAndGet();
	}
    
    

}