package test.ejb;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class Test
 */
@Stateless
public class Test implements TestRemote, TestLocal {

	@Override
    public String greeting(String name) {
    	return "hei ";
    }

}