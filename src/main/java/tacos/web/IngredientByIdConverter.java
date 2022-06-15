package tacos.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import tacos.Ingredient;
import tacos.data.IngredientRepository;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
	
	private IngredientRepository repo;
	
	@Autowired
	public IngredientByIdConverter(IngredientRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public Ingredient convert(String id) {
		Optional<Ingredient> optionalIngredient = repo.findById(id);
		return optionalIngredient.isPresent() ? optionalIngredient.get() : null;
	}
}
