package tn.esprit.spring.services;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class EntrepriseServiceImplTest {
	
	@Autowired
	IEntrepriseService es;

	@Autowired
	IDepartementService ed;
	
	 @Autowired
	EntrepriseRepository  mockEntRepository;
	
	 @Autowired
	DepartementRepository  mockDepRepository;
	
	@After
    public void cleanUp() {
		mockDepRepository.deleteAll();
		mockEntRepository.deleteAll();;
    }
	
	@Test
	public void testAjouterEntreprise() throws Exception {
		//Test add entreprise
		Entreprise mockEnt = new Entreprise("NameEntreprise","raisonSocialEntreprise");
		int mockId = es.ajouterEntreprise(mockEnt);
		assertEquals("NameEntreprise", es.getEntrepriseById(mockId));
	}
	
	@Test
	public void testAjouterDepartement() throws Exception {
		//Test add departement
		Departement mockDep = new Departement("NameDep");
		int mockId = es.ajouterDepartement(mockDep);
		assertTrue(ed.getAllDepartements().contains(mockDep));
	}
	
	@Test
	public void testAffecterDepartementAEntreprise() throws Exception {
		
	}
	
	@Test
	public void testGetAllDepartementsNamesByEntreprise() throws Exception {
		
	}
	
	@Test
	public void testDeleteEntrepriseById() throws Exception {
		Entreprise mockEnt = new Entreprise("NameEntreprise","raisonSocialEntreprise");
		int mockId = es.ajouterEntreprise(mockEnt);
		mockEntRepository.deleteById(mockId);
		assertNull(mockEntRepository.findById(mockId));
	}
	
	@Test
	public void testDeleteDepartementById() throws Exception {
		Departement mockDep = new Departement("NameDep");
		int mockId = es.ajouterDepartement(mockDep);
		mockDepRepository.deleteById(mockId);
		assertNull(mockDepRepository.findById(mockId));
	}
	
	@Test
	public void testGetEntrepriseById() throws Exception {
		Entreprise mockEnt = new Entreprise("NameEntreprise","raisonSocialEntreprise");
		int mockId = es.ajouterEntreprise(mockEnt);
		Entreprise ent = es.getEntrepriseById(mockId);
		assertEquals("NameEntreprise", ent.getName());
		assertEquals("raisonSocialEntreprise", ent.getRaisonSocial());
	}
	
	
}
