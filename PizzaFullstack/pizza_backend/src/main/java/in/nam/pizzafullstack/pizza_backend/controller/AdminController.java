package in.nam.pizzafullstack.pizza_backend.controller;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nam.pizzafullstack.pizza_backend.exception.ResourceNotFoundException;
import in.nam.pizzafullstack.pizza_backend.model.Admin;
import in.nam.pizzafullstack.pizza_backend.repository.AdminRepository;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	AdminRepository adminRepo;
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{adminID}")
	public Admin getAdminByAdminID(@PathVariable("adminID") String adminID)
	{
		Admin admin = adminRepo.findByAdminID(adminID);
		if(admin != null)
		{
			return admin;
		}
		else
		{
			throw new ResourceNotFoundException("Admin not found with adminID " + adminID);
		}
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
	public Admin createAdmin(@RequestBody Admin newAdmin)
	{
		adminRepo.save(newAdmin);
		return newAdmin;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/{adminID}")
	public Admin updateAdmin(@PathVariable("adminID") String adminID, @RequestBody Admin updatedAdmin)
	{
		Admin admin = adminRepo.findByAdminID(adminID);
		if(admin != null)
		{
			admin.setAdminID(updatedAdmin.getAdminID());
			admin.setName(updatedAdmin.getName());
			admin.setPassword(updatedAdmin.getPassword());
			admin.setRole(updatedAdmin.getRole());
			admin.setEmail(updatedAdmin.getEmail());
			adminRepo.save(admin);
			return admin;
		}
		else
		{
			throw new ResourceNotFoundException("Admin not found with adminID " + adminID);
		}
	}
	
	public Map<String, Boolean> deleteAdmin(@PathVariable("adminID") String adminID)
	{
		Map<String, Boolean> map = new HashMap<>();
		adminRepo.delete(null);
		return map;
	}
}
