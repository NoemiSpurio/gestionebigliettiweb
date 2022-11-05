package it.prova.gestionebigliettiweb.service;

import java.util.List;

import it.prova.gestionebigliettiweb.dao.BigliettoDAO;
import it.prova.gestionebigliettiweb.model.Biglietto;

public interface BigliettoService {
	
	public void setBigliettoDao(BigliettoDAO bigliettoDao);
	
	public List<Biglietto> listAll() throws Exception;
	
	public Biglietto caricaSingoloElemento(Long idInput) throws Exception;
	
	public void aggiorna(Biglietto input) throws Exception;
	
	public void inserisciNuovo(Biglietto input) throws Exception;
	
	public void rimuovi(Long idInput) throws Exception;
	
	public List<Biglietto> trovaByExample(Biglietto input) throws Exception;

}
