package in.nam.pizzafullstack.pizza_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.nam.pizzafullstack.pizza_backend.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	Admin findByAdminID(String adminID);
}
