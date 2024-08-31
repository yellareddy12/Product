package com.techpalle.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techpalle.demo.Entity.Project1;
import com.techpalle.demo.Repository.InventoryRepository;

@Service 
public class Servicelayes {
private InventoryRepository repository;
@Autowired
public Servicelayes(InventoryRepository repository) {
	this.repository=repository;
}
public Project1 saveProduct(Project1 p) {
	Project1 j=repository.save(p);
	return j;
}
public void delete(int pid) {
	repository.deleteById(pid);
}
public List<Project1> getall(){
	List<Project1> pp=repository.findAll();
	return pp;
}
public Project1 updateData(int pid,Project1 ppp) {
	Optional<Project1> tem=repository.findById(pid);
	if(tem.isPresent()) {
		Project1 j=tem.get();
		j.setPname(ppp.getPname());
		j.setPprice(ppp.getPprice());
		j.setPqty(ppp.getPqty());
		return repository.save(j);
	}else {
		throw new RuntimeException("product not found");
	}
}
public Optional<Project1> getvalue(int id) {
	Optional<Project1> pp=repository.findById(id);
	return pp;
}
}
