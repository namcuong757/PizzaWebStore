package in.nam.pizzafullstack.pizza_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nam.pizzafullstack.pizza_backend.model.Pizza;


@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long>{

}
