package app;

import static spark.Spark.*;
import service.ProdutoService;


public class Aplicacao {
	
	private static ProdutoService produtoService = new ProdutoService();
	
    public static void main(String[] args) {
        port(6800);

        post("/personagem", (request, response) -> produtoService.inserirUsuario(request, response));

        get("/produto/delete/:id", (request, response) -> produtoService.excluirUsuario(request, response));

        get("/produto", (request, response) -> produtoService.getUsuarios(request, response));
               
    }
}
