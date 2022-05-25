package app;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.Spark.staticFiles;

import Services.VagasService;

public class SparkRestController {

	public static void main(String[] args) {

		final VagasService vagasService = new VagasService();
		port(6787);
		staticFiles.location("/public");
		post("/usuario", (request, response) -> {
			return vagasService.addVagas(request, response);
		});

		get("/usuario", (request, response) -> {
			return vagasService.getVaga(request, response);
		});

		get("/usuario/:id", (request, response) -> {
            return vagasService.getVagas(request, response);
		});

		put("/usuario/:id", (request, response) -> {
            return vagasService.editVagas(request, response);
		});

		delete("/usuario/:id", (request, response) -> {
			return vagasService.deleteVagas(request, response);
		});

	}
	
}
