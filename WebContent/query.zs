import it.awta.awtagest.*;

void salva(){
	Scuola scuolaDummy = new Scuola();
	ScuolaDAO scuolaDAODummy = new ScuolaDAO();
	scuolaDummy.setSc_id(2);
	scuolaDummy.setSc_nome("Caivano2");
	scuolaDAODummy.saveOrUpdate(scuolaDummy);
}