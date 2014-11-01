package cn.zyc.proxy;

public class MainDynProxy {

	public static void main(String[] args) throws Exception {
		IDBQuery query = null;
		//测试jdk动态代理
		long beginTime = System.currentTimeMillis();
		query = JdkDBQueryHandler.createJdkProxy();
		System.out.println(query.query());
		System.out.println("create jdkProxy: "
				+ (System.currentTimeMillis() - beginTime));
		System.out.println("jdkProxy class: " + query.getClass().getName());
		beginTime = System.currentTimeMillis();
		for (int i = 0; i < 30000000; i++)
			query.query();
		System.out.println("call jdkProxy method: "
				+ (System.currentTimeMillis() - beginTime));
		
		System.out.println();
		
		//测试cglib动态代理
		beginTime = System.currentTimeMillis();
		query = CglibDBQueryInterceptor.createCglibProxy();
		System.out.println(query.query());
		System.out.println("create cglibProxy: "
				+ (System.currentTimeMillis() - beginTime));
		System.out.println("cglibProxy class: " + query.getClass().getName());
		beginTime = System.currentTimeMillis();
		for (int i = 0; i < 30000000; i++)
			query.query();
		System.out.println("call cglibProxy method: "
				+ (System.currentTimeMillis() - beginTime));
		
		System.out.println();
		
		//测试javassist 工厂创建
		beginTime = System.currentTimeMillis();
		query = JavassistDynDBQueryHandler.createJavassitDynProxy();
		System.out.println(query.query());
		System.out.println("create javassistDynProxy: "
				+ (System.currentTimeMillis() - beginTime));
		System.out.println("javassistDynProxy class: " + query.getClass().getName());
		beginTime = System.currentTimeMillis();
		for (int i = 0; i < 30000000; i++)
			query.query();
		System.out.println("call javassistDynProxy method: "
				+ (System.currentTimeMillis() - beginTime));
		
		System.out.println();
		
		//测试javassist 动态java代码创建代理
		beginTime = System.currentTimeMillis();
		query = JavassistDynDBQueryHandler.createJavassitBytecodeDynProxy();
		System.out.println(query.query());
		System.out.println("create javassistBytecodeDynProxy: "
				+ (System.currentTimeMillis() - beginTime));
		System.out.println("javassistBytecodeDynProxy class: " + query.getClass().getName());
		beginTime = System.currentTimeMillis();
		for (int i = 0; i < 30000000; i++)
			query.query();
		System.out.println("call javassistBytecodeDynProxy method: "
				+ (System.currentTimeMillis() - beginTime));
	}
}
