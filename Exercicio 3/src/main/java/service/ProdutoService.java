package service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import spark.Request;
import spark.Response;

import DAO.PersonagemDAO;
import model.Usuario;

public class ProdutoService {

	private PersonagemDAO personagemDAO;

	public ProdutoService() {
			personagemDAO = new PersonagemDAO();
	}
	
	public Object inserirUsuario(Request request, Response response) {

		int player_id = Integer.parseInt(request.queryParams("player"));
		int skin_id = Integer.parseInt(request.queryParams("Skin"));
		
		boolean resultados = false;
		if( Integer.parseInt(request.queryParams("mana_tip")) == 1 )
		{
		 resultados = true;
		}
		else
		{
			resultados = false;
		}
		
		boolean mana_tip = resultados;
		int power = Integer.parseInt(request.queryParams("power"));

		Usuario usuario = new Usuario(player_id, skin_id, mana_tip, power);
		personagemDAO.inserirUsuario(usuario);

		response.status(201); // 201 Created
		return player_id;
	}


	public Object excluirUsuario(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));

        boolean haver = personagemDAO.get(id);

        if (haver != true) {

            personagemDAO.excluirUsuario(id);

            response.status(200); // success
        	return id;
        } else {
            response.status(404); // 404 Not found
            return "Personagem não encontrado.";
        }
	}

	public Object getUsuarios(Request request, Response response) {
		Usuario[] usuarios = null;
		usuarios = personagemDAO.getUsuarios();
		StringBuffer returnValue = new StringBuffer("<personagens type=\"array\">");
		for (int i = 0; i < usuarios.length; i++) {
			returnValue.append("\n<personagens>\n" + 
            		"\t<player_id>" + usuarios[i].getplayer_id() + "</player_id>\n" +
            		"\t<skin_id>" + usuarios[i].getskin_id() + "</skin_id>\n" +
            		"\t<mana_tip>" + usuarios[i].getmana_tip() + "</mana_tip>\n" +
            		"\t<power>" + usuarios[i].getpower() + "</power>\n" +
            		"</personagens>\n");
		}
		returnValue.append("</personagens>");
	    response.header("Content-Type", "application/xml");
	    response.header("Content-Encoding", "UTF-8");
		return returnValue.toString();
	}
}