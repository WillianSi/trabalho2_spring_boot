package br.edu.ifsuldeminas.mch.si.webii.postmanager.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.Role;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.repositories.RoleRepository;

@Component
public class InitializeDataBase2 implements CommandLineRunner{
	
	@Autowired
	//private UserRepository uRepo;
	private RoleRepository rRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Role luiz = new Role();
		luiz.setCargo("Gerente");
		luiz.setIdade("27");
		luiz.setUsuario("Emerson");
		
		rRepo.save(luiz);
	}
}
