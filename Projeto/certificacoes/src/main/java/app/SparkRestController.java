package app;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.Spark.staticFiles;

import Services.CertificacoesService;

public class SparkRestController {

	public static void main(String[] args) {

		final CertificacoesService certificacoesService = new CertificacoesService();
		port(6787);
		staticFiles.location("/public");
		post("/usuario", (request, response) -> {
			return certificacoesService.addCertificacoes(request, response);
		});

		get("/usuario", (request, response) -> {
			return certificacoesService.getCertificacao(request, response);
		});

		get("/usuario/:id", (request, response) -> {
            return certificacoesService.getCertificacoes(request, response);
		});

		put("/usuario/:id", (request, response) -> {
            return certificacoesService.editCertificacoes(request, response);
		});

		delete("/usuario/:id", (request, response) -> {
			return certificacoesService.deleteCertificacoes(request, response);
		});

	}
	
}
