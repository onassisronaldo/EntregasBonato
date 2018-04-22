package service;

import dao.OlimpiadaDao;
import model.Olimpiada;

public class OlimpiadaService {
OlimpiadaDao dao = new OlimpiadaDao();
	
	public int criar(Olimpiada Olimpiada) {
		return dao.criar(Olimpiada);
	}
	
	public void atualizar(Olimpiada Olimpiada){
		dao.atualizar(Olimpiada);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	
	public Olimpiada carregar(int id){
		return dao.carregar(id);
	}
}
