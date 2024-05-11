package br.edu.senaisp.Pastel.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.edu.senaisp.Pastel.model.Pastel;


@Repository
public class PastelRepository implements ICrud{

	private final String qrSelect = "SELECT id, sabor FROM pastel";
	private final String qrSelectById = "SELECT id, sabor FROM pastel WHERE id = ?";
	private String qrInsert = "INSERT INTO pastel (id, sabor) VALUES(default, ?)";
	private String qrUpdate = "UPDATE pastel SET sabor = ? WHERE id = ?";
	private String qrDelete = "DELETE FROM pastel WHERE id = ?;";
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Pastel> list() {
		
		return jdbcTemplate.query(qrSelect, (rs, rowNum) -> {
			return new Pastel(rs.getInt("id"),
								rs.getString("sabor"));
		});
		
	}

	@Override
	public Pastel findById(int id) {
		Object [] params = {id};
		return jdbcTemplate.queryForObject(qrSelectById, params, (rs, rowNum) -> {
			return new Pastel(rs.getInt("id"),
					rs.getString("sabor"));
	});
		
	}

	@Override
	public List<Pastel> insert(Pastel pastel) {
		Object [] params = {pastel.getSabor()};
		jdbcTemplate.update(qrInsert, params);
		
		return list();
	}

	@Override
	public Pastel update(Pastel pastel, int id) {
		Object [] params = {pastel.getSabor(), id};
		jdbcTemplate.update(qrUpdate, params);
		return findById(id);
	}

	@Override
	public void delete(int id) {
		Object [] params = {id};
		jdbcTemplate.update(qrDelete, params);
		
	}

	
	
}
