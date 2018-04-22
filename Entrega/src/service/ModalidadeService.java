package service;

import model.Modalidade;
import model.Olimpiada;
import dao.ModalidadeDao;

public class ModalidadeService {
	ModalidadeDao dao = new ModalidadeDao();

	public Modalidade criar(Modalidade modalidade, Olimpiada olimpiada) {
        return dao.criar(modalidade, olimpiada);
    }
	
	public void atualizar(Modalidade modalidade, Olimpiada olimpiada){
		dao.atualizar(modalidade, olimpiada);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	
	public Modalidade carregar(Modalidade modalidade){
		return dao.carregar(modalidade);
	}
	
}