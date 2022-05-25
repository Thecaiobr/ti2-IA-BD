package Services;

import com.google.gson.Gson;

import DAO.VagasDAO;
import Erros.VagasException;
import model.Vagas;
import response.StandardResponse;
import response.StatusResponse;
import spark.Request;
import spark.Response;

public class VagasService {

	private VagasDAO vagasDao = new VagasDAO();

	public void addVagas(Vagas emp) {
		System.out.print(emp);
	}
	
	public String addVagas(Request request, Response response) {
		// Employee employee = new Employee(emp.getId(), emp.getFirstName(),
		// emp.getLastName(), emp.getEmail());
		response.type("application/json");
		response.header("Access-Control-Allow-Origin", "*");
		response.header("Access-Control-Allow-Methods", "POST");
		response.header("Access-Control-Allow-Headers",
				"Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");

		Vagas vagas = new Gson().fromJson(request.body(), Vagas.class);
		boolean status = vagasDao.insert(vagas);
		if (status == true) {
			return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, "Adicionado com sucesso"));
		} else {
			return new Gson().toJson(new StandardResponse(StatusResponse.ERROR,
					new Gson().toJson("Erro ao inserir o  usuario na tabela de dados")));
		}
	}
	
	
	public String getVaga(Request request, Response response) {
		response.type("application/json");
		response.header("Access-Control-Allow-Origin", "*");
		response.header("Access-Control-Allow-Methods", "GET");
		response.header("Access-Control-Allow-Headers",
				"Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");
		return new Gson()
				.toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(vagasDao.getVagas())));

	}
	
	
	public String getVagas(Request request, Response response) {
		response.type("application/json");
		response.header("Access-Control-Allow-Origin", "*");
		response.header("Access-Control-Allow-Methods", "GET");
		response.header("Access-Control-Allow-Headers",
				"Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");

		return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS,
				new Gson().toJsonTree(vagasDao.get(Integer.parseInt(request.params(":id"))))));

	}
	
	
	public String editVagas(Request request, Response response) throws VagasException {
		response.type("application/json");
		response.header("Access-Control-Allow-Origin", "*");
		response.header("Access-Control-Allow-Methods", "GET");
		response.header("Access-Control-Allow-Headers",
				"Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");

		Vagas forEdit = new Gson().fromJson(request.body(), Vagas.class);

		try {

			Vagas toEdit = vagasDao.get(Integer.parseInt((request.params(":id"))));

			if (toEdit == null)
				return new Gson().toJson(new StandardResponse(StatusResponse.ERROR,
						new Gson().toJson("Vaga não encontrada , preencha todos os campos!")));

			if (forEdit.getTipo() != null) {
				toEdit.setTipo(forEdit.getTipo());
			}
			if (forEdit.getDescricao() != null) {
				toEdit.setDescricao(forEdit.getDescricao());
			}
			if (forEdit.getEmpresa() != null) {
				toEdit.setEmpresa(forEdit.getEmpresa());
			}
			if (forEdit.getTipo_candidato() != null) {
				toEdit.setTipo_candidato(forEdit.getTipo_candidato());
			}

			if (vagasDao.atualizarVagas(toEdit) == true) {
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
	
	
	public String deleteVagas(Request request, Response response) {

		response.type("application/json");
		response.header("Access-Control-Allow-Origin", "*");
		response.header("Access-Control-Allow-Methods", "GET");
		response.header("Access-Control-Allow-Headers",
				"Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");

		boolean delete = vagasDao.delete(Integer.parseInt(request.params(":id")));
		if (delete) {
			return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, "vaga deletada com sucesso"));
		} else {

			return new Gson().toJson(new StandardResponse(StatusResponse.ERROR,
					new Gson().toJson("Erro ao deletar , vaga não existe na base!")));
		}

	}

	public boolean vagasExist(String id) {
		// return vagasMap.containsKey(id);
		return false;
	}
}
