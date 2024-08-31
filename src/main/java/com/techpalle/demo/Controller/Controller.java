package com.techpalle.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techpalle.demo.Entity.Project1;
import com.techpalle.demo.Service.Servicelayes;

@RestController
@RequestMapping("/api/v1")
public class Controller {
private Servicelayes service;
@Autowired
public  Controller(Servicelayes service) {
	this.service=service;
}
@PostMapping("/savep")
public ResponseEntity<Project1> saveproduct(@RequestBody Project1 p) {
	Project1 pp=service.saveProduct(p);
	return ResponseEntity.ok(pp);
	
}
@DeleteMapping("/delete/{pid}")
public void deleteid(@PathVariable int pid) {
	service.delete(pid);
}
@GetMapping("/get")
public List<Project1> findall(){
	List<Project1> k=service.getall();
	return k;
}
@PutMapping("/rrr/{pid}")
public Project1 update(@PathVariable int pid,@RequestBody Project1 p) {
	return service.updateData(pid,p);
	
}
@GetMapping("/get1/{id}")
public ResponseEntity<Project1> findall(@PathVariable int id){
Optional<Project1> o=service.getvalue(id);
if(o.isPresent()) {
	return ResponseEntity.ok(o.get());
}else {
       throw new RuntimeException("product not found");
}
}

}
