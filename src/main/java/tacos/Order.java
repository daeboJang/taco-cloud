package tacos;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

@Data
public class Order {
	
	@NotBlank(message = "Name is required")
	private String deliveryName;
	private String deliveryStreet;
	private String deliveryCity;
	private String deliveryState;
	private String deliveryZip;
	
	
	@CreditCardNumber(message = "이거 니 카드 아니지??")
	private String ccNumber;
	
	
	private String ccExpiration;
	
	@Digits(integer=3, fraction=0, message = "Invalid CVV")
	private String ccCVV;
	
}
