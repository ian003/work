package cn.zyc.proxy;

public class DBQueryProxy implements IDBQuery {

	private DBQuery dbQuery;

	@Override
	public String query() {
		if (dbQuery == null) {
			dbQuery = new DBQuery();
		}
		System.out.println("proxy 调用被代理类方法");
		return dbQuery.query();
	}

}
