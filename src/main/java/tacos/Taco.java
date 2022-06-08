package tacos;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Taco {

	@NotNull
	@Size(min=5, message="Name 은 최소 5글자 이상이어야 해!")
	private String name;
	
	@Size(min=1, message = "1개 이상의 재료를 선택해라!")
	private List<String> ingredients;
}
