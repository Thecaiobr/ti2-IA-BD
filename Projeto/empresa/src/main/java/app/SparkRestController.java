package app;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.Spark.staticFiles;

import Services.EmpresaService;

public class SparkRestController {

	public static void main(String[] args) {

		final EmpresaService usuarioService = new EmpresaService();
		port(6787);
		staticFiles.location("/public");
		post("/usuario", (request, response) -> {
			return usuarioService.addEmpresaBanco(request, response);
		});

		get("/usuario", (request, response) -> {
			return usuarioService.getEmpresa(request, response);
		});

		get("/usuario/:id", (request, response) -> {
            return usuarioService.getEmpresas(request, response);
		});

		put("/usuario/:id", (request, response) -> {
            return usuarioService.editEmpresa(request, response);
		});

		delete("/usuario/:id", (request, response) -> {
			return usuarioService.deleteEmpresa(request, response);
		});

	}
	
}
