package test.ejb;

import javax.ejb.Remote;

@Remote
public interface TestRemote {
	
	String greeting(String name);
}
