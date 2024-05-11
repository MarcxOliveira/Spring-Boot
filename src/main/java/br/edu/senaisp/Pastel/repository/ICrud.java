package br.edu.senaisp.Pastel.repository;

import java.util.List;

import br.edu.senaisp.Pastel.model.Pastel;

public interface ICrud {
 
	public List<Pastel> list();
	
	public Pastel findById(int id);
	
	public List<Pastel> insert(Pastel pastel);
	
	public Pastel update(Pastel pastel, int id);
	
	public void delete(int id);
} 
