package com.nander.springdata.repository;

import com.nander.springdata.orm.Position;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends CrudRepository<Position, Integer> {

	
}