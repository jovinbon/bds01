package com.devsuperior.bds01.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds01.dto.DepartmentDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.repositories.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository repository;
	
	// --------lista sem paginação com ordenação--------
	@Transactional(readOnly = true)
	public List<DepartmentDTO> findAll(){
		List<Department> list = repository.findAll(Sort.by("name"));
		return list.stream().map(x -> new DepartmentDTO(x)).collect(Collectors.toList());
	}
	
	/* --lista normal do repository--
	@Transactional(readOnly = true)
	public List<Category> findAll(){
		return repository.findAll();
	}

	 /* --adicionando uma category numa lista DTO   
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll(){
		List<Category> list = repository.findAll();
		
		List<CategoryDTO> listDto = new ArrayList<>();
		for (Category cat : list) {
			listDto.add(new CategoryDTO(cat));
		}
		
		return listDto;
	}*/
	
	// --------lista com paginação com PageRequest--------
	/*public Page<CategoryDTO> findAllPaged(PageRequest pageResquest) {
		Page<Category> list = repository.findAll(pageResquest);
		return list.map(x -> new CategoryDTO(x));
	}*/
	
	/* --------lista com paginação com Pageable--------
	public Page<CategoryDTO> findAllPaged(Pageable pageable) {
		Page<Category> list = repository.findAll(pageable);
		return list.map(x -> new CategoryDTO(x));
	}*/

}
