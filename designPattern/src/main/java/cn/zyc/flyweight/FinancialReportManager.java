package cn.zyc.flyweight;

public class FinancialReportManager implements IReportManager {

	private String id;

	public FinancialReportManager(String id) {
		this.id = id;
	}

	@Override
	public String createReport() {
		return "financial report manager ---> " + id;
	}

}
