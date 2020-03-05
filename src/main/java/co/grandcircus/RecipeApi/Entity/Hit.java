package co.grandcircus.RecipeApi.Entity;

import javax.persistence.Entity;

@Entity
public class Hit {
	
	private Recipe recipe;

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	@Override
	public String toString() {
		return "Hit [recipe=" + recipe + "]";
	}
	
}
