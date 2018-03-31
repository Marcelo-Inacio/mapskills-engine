/*
 * @(#)InstitutionApplicationServices.java 1.0 1 02/09/2017
 *
 * Copyright (c) 2017, Fatec-Jessen Vidal. All rights reserved.
 * Fatec-Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */

package br.gov.sp.fatec.mapskills.application;

import java.io.InputStream;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.mapskills.domain.institution.Course;
import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionDomainServices;
import br.gov.sp.fatec.mapskills.domain.user.student.Student;
import br.gov.sp.fatec.mapskills.domain.user.student.StudentSpecification;
import lombok.AllArgsConstructor;

/**
 * A classe {@link InstitutionApplicationServices} contem as funcionalidades
 * referentes as instituicoes da aplicacao.
 *
 * @author Marcelo
 * @version 1.0 02/09/2017
 */
@ApplicationServices
@AllArgsConstructor
public class InstitutionApplicationServices {
	
	private final InstitutionDomainServices domainServices;
	
	@Transactional
	@PreAuthorize("isFullyAuthenticated()")
	public void updateGameThemeInstitution(final String institutionCode, final Long gameThemeId) {
		domainServices.updateGameTheme(institutionCode, gameThemeId);
	}
	
	@Transactional
	@PreAuthorize("isFullyAuthenticated()")
	public void importInstitutions(final InputStream inputStream) {
		domainServices.importInstitutions(inputStream);
	}
	
	@Transactional
	@PreAuthorize("isFullyAuthenticated()")
	public void saveInstitution(final Institution newInstitution) {
		domainServices.saveInstitution(newInstitution);
	}
	
	@Transactional
	@PreAuthorize("isFullyAuthenticated()")
	public void updateInstitution(final Long id, final Institution institution) {
		domainServices.updateInstitution(id, institution);
	}
	
	@PreAuthorize("isFullyAuthenticated()")
	public List<Institution> getAllInstitutions() {
		return domainServices.getAllInstitutions();
	}
	
	@PreAuthorize("isFullyAuthenticated()")
	public Institution getInstitutionById(final Long id) {
		return domainServices.getInstitutionById(id);
	}
	
	@Transactional
	@PreAuthorize("isFullyAuthenticated()")
	public void saveCourse(final Course newCourse) {
		domainServices.saveCourse(newCourse);
	}
	
	@Transactional
	@PreAuthorize("isFullyAuthenticated()")
	public void updateCourse(final Long courseId, final Course course) {
		domainServices.updateCourse(courseId, course);
	}

	@PreAuthorize("isFullyAuthenticated()")
	public Page<Student> getStudents(final StudentSpecification specification, final Pageable pageable) {
		return domainServices.getStudents(specification, pageable);
	}

	@PreAuthorize("isFullyAuthenticated()")
	public List<Course> getCoursesByInstitutionCode(final String institutionCode) {
		return domainServices.getCoursesByInstitutionCode(institutionCode);
	}
}