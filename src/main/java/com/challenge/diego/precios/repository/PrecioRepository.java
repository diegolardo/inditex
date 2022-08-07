package com.challenge.diego.precios.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.challenge.diego.precios.entities.persistence.PrecioEntity;

@Repository
public interface PrecioRepository extends JpaRepository<PrecioEntity, Long>, JpaSpecificationExecutor<PrecioEntity> {

	public List<PrecioEntity> findAll(Specification<PrecioEntity> spec);
}
