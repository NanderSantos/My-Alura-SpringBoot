package com.nander.springdata.repository;

import com.nander.springdata.orm.WorkUnit;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkUnitRepository extends CrudRepository<WorkUnit, Integer> {
	
}
