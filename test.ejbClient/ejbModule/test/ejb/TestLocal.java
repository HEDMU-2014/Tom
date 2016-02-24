package test.ejb;

import javax.ejb.Local;

@Local
public interface TestLocal {

	String greeting(String name);
}
