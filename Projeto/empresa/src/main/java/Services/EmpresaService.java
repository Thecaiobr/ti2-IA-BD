package Services;

import com.google.gson.Gson;

import DAO.EmpresaDAO;
import model.Empresa;
import response.StandardResponse;
import response.StatusResponse;
import spark.Request;
import spark.Response;


public class EmpresaService {
	private EmpresaDAO empresaDao = new EmpresaDAO();

	public void addEmpresa(Empresa emp) {
		System.out.print(emp);
	}
	
	public String addEmpresaBanco(Request request, Response response) {
		// Employee employee = new Employee(emp.getId(), emp.getFirstName(),
		// emp.getLastName(), emp.getEmail());
		response.type("application/json");
		response.header("Access-Control-Allow-Origin", "*");
		response.header("Access-Control-Allow-Methods", "POST");
		response.header("Access-Control-Allow-Headers",
				"Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");

		Empresa empresa = new Gson().fromJson(request.body(), Empresa.class);
		boolean status = empresaDao.insert(empresa);
		if (status == true) {
			return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, "Adicionado com sucesso"));
		} else {
			return new Gson().toJson(new StandardResponse(StatusResponse.ERROR,
					new Gson().toJson("Erro ao inserir o  usuario na tabela de dados")));
		}
	}
	
	public String getEmpresas(Request request, Response response) {
		response.type("application/json");
		response.header("Access-Control-Allow-Origin", "*");
		response.header("Access-Control-Allow-Methods", "GET");
		response.header("Access-Control-Allow-Headers",
				"Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");
		return new Gson()
				.toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(empresaDao.getEmpresa())));

	}

	public String getEmpresa(Request request, Response response) {
		response.type("application/json");
		response.header("Access-Control-Allow-Origin", "*");
		response.header("Access-Control-Allow-Methods", "GET");
		response.header("Access-Control-Allow-Headers",
				"Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");

		return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS,
				new Gson().toJsonTree(empresaDao.get(Integer.parseInt(request.params(":id"))))));

	}
	
	public String editEmpresa(Request request, Response response)  {
		response.type("application/json");
		response.header("Access-Control-Allow-Origin", "*");
		response.header("Access-Control-Allow-Methods", "GET");
		response.header("Access-Control-Allow-Headers",
				"Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");

		Empresa forEdit = new Gson().fromJson(request.body(), Empresa.class);

		try {
			if (forEdit.getId() == 0)
				return new Gson().toJson(new StandardResponse(StatusResponse.ERROR,
						new Gson().toJson("Usuario não encontrado , preencha todos os campos!")));

			Empresa toEdit = empresaDao.get(Integer.parseInt((request.params(":id"))));

			if (toEdit == null)
				return new Gson().toJson(new StandardResponse(StatusResponse.ERROR,
						new Gson().toJson("Usuario não encontrado , preencha todos os campos!")));

			if (forEdit.getNomeEmpresa() != null) {
				toEdit.setNomeempresa(forEdit.getNomeEmpresa());
			}
			if (forEdit.getUserid() != null) {
				toEdit.setUserid(forEdit.getUserid());
			}
			if (forEdit.getCnpj() != 0) {
				toEdit.setCnpj(forEdit.getCnpj());
			}
			if (forEdit.getRamo() != null) {
				toEdit.setRamo(forEdit.getRamo());
			}
			if (forEdit.getSite() != null) {
				toEdit.setSite(forEdit.getSite());
			}
			if (forEdit.getPais() != null) {
				toEdit.setPais(forEdit.getPais());
			}
			if (forEdit.getEstado() != null) {
				toEdit.setEstado(forEdit.getEstado());
			}
			if (forEdit.getCidade() != null) {
				toEdit.setCidade(forEdit.getCidade());
			}
			if (forEdit.getBairro() != null) {
				toEdit.setBairro(forEdit.getBairro());
			}
			if (forEdit.getTelefone() != null) {
				toEdit.setTelefone(forEdit.getTelefone());
			}
			if (forEdit.getEmail() != null) {
				toEdit.setEmail(forEdit.getEmail());
			}
			

			if (empresaDao.atualizarEmpresa(toEdit) == true) {
				return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(forEdit)));
			} else {
				return new Gson().toJson(new StandardResponse(StatusResponse.ERROR,
						new Gson().toJson("Erro ao atualizar, preencha todos os campos!")));
			}

		} catch (Exception ex) {
			return new Gson().toJson(new StandardResponse(StatusResponse.ERROR,
					new Gson().toJson("Erro ao  atualizar , preencha todos os campos!")));
		}
	}
	
	public String deleteEmpresa(Request request, Response response) {
		try {
			response.type("application/json");
			response.header("Access-Control-Allow-Origin", "*");
			response.header("Access-Control-Allow-Methods", "GET");
			response.header("Access-Control-Allow-Headers",
					"Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");
			
			empresaDao.delete(request.params(":id"));
			return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, "usuario deletado com sucesso"));
		} catch (Exception ex) {
			return new Gson().toJson(new StandardResponse(StatusResponse.ERROR,
					new Gson().toJson("Erro ao deletar , usuario não existe na base!")));
		}

	}
}
