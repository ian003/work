package cn.zyc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 * 
 * @author zyc
 * 
 */
public class JdkDBQueryHandler implements InvocationHandler {

	private IDBQuery real;

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if (null == real) {
			real = new DBQuery();
		}
		return real.query();
	}

	public static IDBQuery createJdkProxy() {
		IDBQuery jdkProxy = (IDBQuery) Proxy.newProxyInstance(
				ClassLoader.getSystemClassLoader(),
				new Class[] { IDBQuery.class }, new JdkDBQueryHandler());
		return jdkProxy;
	}
}
