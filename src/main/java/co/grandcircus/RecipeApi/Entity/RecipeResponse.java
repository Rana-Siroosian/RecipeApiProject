package co.grandcircus.RecipeApi.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class RecipeResponse {

	private Long id;
	
	private String q;
	
	private List<Hit> hits;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public List<Hit> getHits() {
		return hits;
	}

	public void setHits(List<Hit> hits) {
		this.hits = hits;
	}

	@Override
	public String toString() {
		return "AllRecipe [id=" + id + ", q=" + q + ", hits=" + hits + "]";
	}
	
}
