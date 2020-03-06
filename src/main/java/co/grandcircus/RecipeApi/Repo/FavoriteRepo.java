package co.grandcircus.RecipeApi.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.RecipeApi.Entity.Favorite;

public interface FavoriteRepo extends JpaRepository <Favorite, Long>{

	
}
