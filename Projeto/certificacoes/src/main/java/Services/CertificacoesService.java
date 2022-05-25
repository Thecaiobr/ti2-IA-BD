package Services;

import com.google.gson.Gson;

import DAO.CertificacoesDAO;
import Erros.CertificacoesException;
import model.Certificacoes;
import response.StandardResponse;
import response.StatusResponse;
import spark.Request;
import spark.Response;

public class CertificacoesService {

	private CertificacoesDAO certificacoesDao = new CertificacoesDAO();

	public void addCertificacoes(Certificacoes emp) {
		System.out.print(emp);
	}

	public String addCertificacoes(Request request, Response response) {
		// Employee employee = new Employee(emp.getId(), emp.getFirstName(),
		// emp.getLastName(), emp.getEmail());
		response.type("application/json");
		response.header("Access-Control-Allow-Origin", "*");
		response.header("Access-Control-Allow-Methods", "POST");
		response.header("Access-Control-Allow-Headers",
				"Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");

		Certificacoes certificacoes = new Gson().fromJson(request.body(), Certificacoes.class);
		boolean status = certificacoesDao.insert(certificacoes);
		if (status == true) {
			return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, "Adicionado com sucesso"));
		} else {
			return new Gson().toJson(new StandardResponse(StatusResponse.ERROR,
					new Gson().toJson("Erro ao inserir o  usuario na tabela de dados")));
		}
	}
	
	public String getCertificacoes(Request request, Response response) {
		response.type("application/json");
		response.header("Access-Control-Allow-Origin", "*");
		response.header("Access-Control-Allow-Methods", "GET");
		response.header("Access-Control-Allow-Headers",
				"Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");
		return new Gson()
				.toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(certificacoesDao.getCertificacoes())));

	}
	
	public String getCertificacao(Request request, Response response) {
		response.type("application/json");
		response.header("Access-Control-Allow-Origin", "*");
		response.header("Access-Control-Allow-Methods", "GET");
		response.header("Access-Control-Allow-Headers",
				"Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");

		return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS,
				new Gson().toJsonTree(certificacoesDao.get(Integer.parseInt(request.params(":id"))))));

	}
	
	public String editCertificacoes(Request request, Response response) throws CertificacoesException {
		response.type("application/json");
		response.header("Access-Control-Allow-Origin", "*");
		response.header("Access-Control-Allow-Methods", "GET");
		response.header("Access-Control-Allow-Headers",
				"Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");

		Certificacoes forEdit = new Gson().fromJson(request.body(), Certificacoes.class);

		try {

			Certificacoes toEdit = certificacoesDao.get(Integer.parseInt((request.params(":id"))));

			if (toEdit == null)
				return new Gson().toJson(new StandardResponse(StatusResponse.ERROR,
						new Gson().toJson("Certificacao não encontrada , preencha todos os campos!")));

			if (forEdit.getTitulo() != null) {
				toEdit.setTitulo(forEdit.getTitulo());
			}
			if (forEdit.getOrg_emissor() != null) {
				toEdit.setOrg_emissor(forEdit.getOrg_emissor());
			}
			if (forEdit.getUrl_credencial() != null) {
				toEdit.setUrl_credencial(forEdit.getUrl_credencial());
			}
			if (forEdit.getCredencial() != null) {
				toEdit.setCredencial(forEdit.getCredencial());
			}

			if (certificacoesDao.atualizarCertificacoes(toEdit) == true) {
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
	
	public String deleteCertificacoes(Request request, Response response) {

		response.type("application/json");
		response.header("Access-Control-Allow-Origin", "*");
		response.header("Access-Control-Allow-Methods", "GET");
		response.header("Access-Control-Allow-Headers",
				"Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");

		boolean delete = certificacoesDao.delete(Integer.parseInt(request.params(":id")));
		if (delete) {
			return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, "certificacao deletada com sucesso"));
		} else {

			return new Gson().toJson(new StandardResponse(StatusResponse.ERROR,
					new Gson().toJson("Erro ao deletar , certficacao não existe na base!")));
		}

	}

	public boolean certificacoesExist(String id) {
		// return certificacoesMap.containsKey(id);
		return false;
	}
	
}
