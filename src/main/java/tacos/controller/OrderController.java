package tacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;
import tacos.Order;
import tacos.data.OrderRepository;

@Controller
@Slf4j
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepo;

	@GetMapping("/current")
	public String orderForm() {
		return "orderForm";
	}
	
	@PostMapping
	public String processOrder(@Validated Order order, Errors errors, SessionStatus sessionStatus) {
		if (errors.hasErrors()) {
			log.info("errors: " + errors);
			return "orderForm";
		}
		
		log.info("Order submitted: " + order);
		
		orderRepo.save(order);
		
		// 세션을 재설정
		sessionStatus.setComplete();
		
		return "redirect:/";
	}
}
