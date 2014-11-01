package cn.zyc.proxy;

public class DBQuery implements IDBQuery {

	public DBQuery() {
		/*try {
			System.out.println("DBQuery 初始化...");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}

	@Override
	public String query() {
		return "DBQuery query something...";
	}

}
