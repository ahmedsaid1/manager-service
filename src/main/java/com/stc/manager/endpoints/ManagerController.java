package com.stc.manager.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stc.manager.model.DepartmentDetails;
import com.stc.manager.model.Manager;
import com.stc.manager.model.ManagerDetails;
import com.stc.manager.service.ManagerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("managers")
@Slf4j
public class ManagerController {
	@Autowired
	ManagerService managerService;

	@PostMapping
	public Manager saveManager(@RequestBody Manager manager) {
		log.info("saveManager methode in ManagerController");

		return managerService.saveManager(manager);
	}

	@GetMapping("/{id}")
	public ManagerDetails getMangerDetails(@PathVariable long id) {
		log.info("getMangerDetails methode in ManagerController");

		return managerService.getMangerDetails(id);
	}
	@GetMapping("/{id}/department")
	public DepartmentDetails getDepartmentDetails(@PathVariable long id) {
		log.info("getMangerDetails methode in ManagerController");

		return managerService.getDepartmentDetails(id);
	}
	
}
