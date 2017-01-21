/*
 * @(#)SkillTest.java 1.0 29/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.domain.skill.SkillService;
import br.gov.sp.fatec.mapskills.test.config.SpringContextTestConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextTestConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class SkillTest extends MapSkillsTest {
	
	@Autowired
	private SkillService service;
	
	@After
	public void cleanTables() {
		super.cleanTables(service);
	}
	
	@Ignore @Test
	public void save() {
		final Skill skill = new Skill("Lideran�a", "Breve descri��o da habilidade");
		service.save(skill);
		
		assertEquals("Lideran�a", service.findById(skill.getId()).getType());
		
	}
	
	@Ignore @Test
	public void testClean() {
		final Collection<Skill> skillList = service.findAll();
		assertTrue(skillList.isEmpty());
		
	}

	@Ignore @Test
	public void update() {
		final Skill skillSave = new Skill("Lideran�a", "Breve descri��o da habilidade");
		service.save(skillSave);
		
		final Skill skillUpdate = new Skill("for�a", "Breve descri��o da habilidade");
		skillUpdate.setId(skillSave.getId());
		service.update(skillUpdate);
		
		assertEquals("for�a", service.findById(skillSave.getId()).getType());
		
	}

}
