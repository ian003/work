package cn.zyc.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * cglib动态代理
 * 
 */
public class CglibDBQueryInterceptor implements MethodInterceptor {

	private IDBQuery real;

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		if (null == real) {
			real = new DBQuery();
		}
		return real.query();
	}

	public static IDBQuery createCglibProxy() {

		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(new CglibDBQueryInterceptor());
		enhancer.setInterfaces(new Class[] { IDBQuery.class });

		IDBQuery cglibProxy = (IDBQuery) enhancer.create();
		return cglibProxy;
	}
}
