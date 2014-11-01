package cn.zyc.proxy;

import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtNewConstructor;
import javassist.CtNewMethod;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

/**
 * javassit 动态代理
 * 
 */
public class JavassistDynDBQueryHandler implements MethodHandler {
	private IDBQuery real;

	@Override
	public Object invoke(Object arg0, Method arg1, Method arg2, Object[] arg3)
			throws Throwable {
		if (null == real) {
			real = new DBQuery();
		}
		return real.query();
	}

	// 1.代理工厂创建
	@SuppressWarnings("rawtypes")
	public static IDBQuery createJavassitDynProxy()
			throws InstantiationException, IllegalAccessException {
		ProxyFactory factory = new ProxyFactory();
		factory.setInterfaces(new Class[] { IDBQuery.class });
		Class c = factory.createClass();
		IDBQuery javassitProxy = (IDBQuery) c.newInstance();
		((ProxyObject) javassitProxy)
				.setHandler(new JavassistDynDBQueryHandler());
		return javassitProxy;
	}

	// 2.动态java代码创建代理
	@SuppressWarnings("rawtypes")
	public static IDBQuery createJavassitBytecodeDynProxy() throws Exception {
		ClassPool pool = new ClassPool(true);
		// 定义类名
		CtClass ctc = pool.makeClass(IDBQuery.class.getName()
				+ "Javassit-BytecodeProxy");
		// 需要实现的接口
		ctc.addInterface(pool.get(IDBQuery.class.getName()));
		// 添加构造函数
		ctc.addConstructor(CtNewConstructor.defaultConstructor(ctc));
		// 添加类的字段信息，使用动态java代码
		ctc.addField(CtField.make("public " + IDBQuery.class.getName()
				+ " real;", ctc));
		String queryName = DBQuery.class.getName();
		// 添加方法，这里使用动态Java代码指定内部逻辑
		ctc.addMethod(CtNewMethod.make(
				"public String query(){if(real==null)real=new " + queryName
						+ "();return real.query();}", ctc));

		// 基于以上信息，生成动态类
		Class pc = ctc.toClass();
		// 生成动态类实例
		IDBQuery bytecodeProxy = (IDBQuery) pc.newInstance();

		return bytecodeProxy;

	}
}
