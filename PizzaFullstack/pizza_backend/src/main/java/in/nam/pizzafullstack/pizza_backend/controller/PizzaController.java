package in.nam.pizzafullstack.pizza_backend.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nam.pizzafullstack.pizza_backend.model.Pizza;
import in.nam.pizzafullstack.pizza_backend.repository.PizzaRepository;
import in.nam.pizzafullstack.pizza_backend.exception.ResourceNotFoundException;


@RestController
@RequestMapping("/api/p1")
public class PizzaController {
	@Autowired
	PizzaRepository repo;
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/pizzas")
	public List<Pizza> getAllPizzas()
	{
		return repo.findAll();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/pizzas/{id}")
	public ResponseEntity<Pizza> getPizza(@PathVariable("id") Long id) {
	    Optional<Pizza> pizza = repo.findById(id);
	    
	    if (pizza.isPresent()) {
	        return ResponseEntity.ok(pizza.get());
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/pizzas")
	public Pizza createPizza(@RequestBody Pizza newPizza)
	{
		repo.save(newPizza);
		return newPizza;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/pizzas/{id}")
	public ResponseEntity<Pizza> updatePizza(@PathVariable("id") Long id,@RequestBody Pizza pizzaDetail)
	{
		Pizza pizza = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pizza not found with id " + id));
		pizza.setType(pizzaDetail.getType());
		pizza.setSide(pizzaDetail.getSide());
		pizza.setDrink(pizzaDetail.getDrink());
		Pizza updatedPizza = repo.save(pizza);
		return ResponseEntity.ok(updatedPizza);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/pizzas/{id}")
	public Map<String, Boolean> deletePizza(@PathVariable("id") Long id)
	{
		Pizza pizza = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pizza not found with id " + id));
		repo.delete(pizza);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", true);
		return response;
	}
}
