package me.dio.academia.digital.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoServiceImpl service;
	
	@PostMapping
	public Aluno create(@Valid @RequestBody AlunoForm form) {
		return service.create(form);
	}	
	
	@GetMapping
	public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento) {
		return service.getAll(dataDeNascimento);
	}
	
	@GetMapping("/avaliacoes/{id}")
	public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
		return service.getAllAvaliacaoFisicaId(id);
	}
	
	@GetMapping("/{id}")
	public Optional<Aluno> findById(@PathVariable Long id) {
		return service.get(id);
	}
	
	@PutMapping("/{id}")
	public Optional<Aluno> update(@PathVariable Long id, @Valid @RequestBody AlunoUpdateForm form) {
		Aluno aluno = (Aluno) service.updateAluno(id, form);
		return Optional.ofNullable(service.updateAluno(id, form));
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id){
		service.delete(id);
	}
}
