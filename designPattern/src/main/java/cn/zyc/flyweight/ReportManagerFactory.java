package cn.zyc.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ReportManagerFactory {

	private Map<String, IReportManager> employee = new HashMap<>();
	private Map<String, IReportManager> financial = new HashMap<>();

	IReportManager getFinancialReportManager(String id) {
		IReportManager rm = financial.get(id);
		if (rm == null) {
			rm = new FinancialReportManager(id);
			financial.put(id, rm);
		}
		return rm;
	}

	IReportManager getEmployeeReportManager(String employeeId) {
		IReportManager rm = employee.get(employeeId);
		if (rm == null) {
			rm = new EmployeeReportManager(employeeId);
			employee.put(employeeId, rm);
		}
		return rm;
	}
}
