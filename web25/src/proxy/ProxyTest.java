package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args) {
		Target target = new Target();
		// TODO Auto-generated method stub
		TargetInface proxy1 = (TargetInface) Proxy.newProxyInstance(Target.class.getClassLoader(),
				target.getClass().getInterfaces(), new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// TODO Auto-generated method stub
						method.invoke(target, args);
						return null;
					}
				});
		proxy1.method1();

	}

}
