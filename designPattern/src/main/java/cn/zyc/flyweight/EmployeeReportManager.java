package cn.zyc.flyweight;

public class EmployeeReportManager implements IReportManager {

	private String employeeId;

	public EmployeeReportManager(String employeeId) {
		System.out.println("first invoke");
		this.employeeId = employeeId;
	}

	@Override
	public String createReport() {
		return "employee report manager ---> " + employeeId;
	}
}
