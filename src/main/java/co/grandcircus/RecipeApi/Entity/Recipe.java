package co.grandcircus.RecipeApi.Entity;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Recipe {

	private String uri;
	private String label;
	private String image;
	private String url;
	private List<String> dietLabels;
	private List<String> ingredientLines;
	private Double calories;
	private Double totalTime;
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<String> getDietLabels() {
		return dietLabels;
	}
	public void setDietLabels(List<String> dietLabels) {
		this.dietLabels = dietLabels;
	}
	public List<String> getIngredientLines() {
		return ingredientLines;
	}
	public void setIngredientLines(List<String> ingredientLines) {
		this.ingredientLines = ingredientLines;
	}
	public Double getCalories() {
		return calories;
	}
	public void setCalories(Double calories) {
		this.calories = calories;
	}
	public Double getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(Double totalTime) {
		this.totalTime = totalTime;
	}
	@Override
	public String toString() {
		return "Recipe [uri=" + uri + ", label=" + label + ", image=" + image + ", url=" + url + ", dietLabels="
				+ dietLabels + ", ingredientLines=" + ingredientLines + ", calories=" + calories + ", totalTime="
				+ totalTime + "]";
	}
	
	
	
}