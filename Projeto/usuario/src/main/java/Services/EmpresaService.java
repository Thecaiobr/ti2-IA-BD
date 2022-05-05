package Services;

import Erros.EmpresaException;
import model.Empresa;
import spark.Request;
import spark.Response;

public class EmpresaService {

	public void addEmpresa(Employee employee);
	public String addEmployeeBanco(Request request, Response response);
	public String getEmployees(Request request, Response response);

	public String getEmployee(Request request, Response response);

	public String editEmployee(Request request, Response response) throws EmployeeException;

	public String deleteEmployee(Request request, Response response);

	public boolean employeeExist(String id);
	
}
