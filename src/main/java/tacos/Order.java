package tacos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

@Data
@Entity
@Table(name="Taco_Order")
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Date placedAt;
	
	@NotBlank(message = "Delivery Name is required")
	private String deliveryName;
	
	@NotBlank(message = "Delivery Street is required")
	private String deliveryStreet;
	
	@NotBlank(message = "Delivery City is required")
	private String deliveryCity;
	
	private String deliveryState;
	private String deliveryZip;
	
	@ManyToMany(targetEntity = Taco.class)
	private List<Taco> tacos = new ArrayList<>();
	
	
	//CreditCardNumber(message = "이거 니 카드 아니지??")
	@NotBlank(message = "이거 니 카드 아니지??")
	private String ccNumber;
	
	// 정규표현식으로 검사해야 함!!!
	private String ccExpiration;
	
	@Digits(integer=3, fraction=0, message = "Invalid CVV")
	private String ccCVV;
	
	public void addDesign(Taco design) {
		this.tacos.add(design);
	}
	
	@PrePersist
	void placedAt() {
		this.placedAt = new Date();
	}
}
