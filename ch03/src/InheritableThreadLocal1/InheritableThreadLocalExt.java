package InheritableThreadLocal1;

import java.util.Date;

public class InheritableThreadLocalExt extends InheritableThreadLocal {

	@Override
	protected Object initialValue() {
		// TODO Auto-generated method stub
		
		return new Date().getTime();
		
	}
	
}
