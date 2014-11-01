package cn.zyc.flyweight;

public class TestFlyWeight {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReportManagerFactory factory = new ReportManagerFactory();
		EmployeeReportManager erm = (EmployeeReportManager) factory
				.getEmployeeReportManager("001");
		System.out.println(erm.createReport());
		EmployeeReportManager erm1 = (EmployeeReportManager) factory
				.getEmployeeReportManager("001");
		System.out.println(erm1.createReport());
	}

}
