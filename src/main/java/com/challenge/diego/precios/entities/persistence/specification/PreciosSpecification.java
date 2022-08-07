package com.challenge.diego.precios.entities.persistence.specification;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.challenge.diego.precios.entities.business.PreciosFilter;
import com.challenge.diego.precios.entities.persistence.PrecioEntity;
import com.challenge.diego.precios.entities.persistence.ProductEntity;

@Component
public class PreciosSpecification {

	public Specification<PrecioEntity> getPreciosByFilter(PreciosFilter filter) {
		return (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			query.orderBy(criteriaBuilder.desc(root.get("priority")));
			if (filter.getBrandId() != null) {
				Join<PrecioEntity, ProductEntity> joinBrand = root.join("brand");
				predicates.add(criteriaBuilder.equal(joinBrand.get("id"), filter.getBrandId()));
			}
			if (filter.getProductId() != null) {
				Join<PrecioEntity, ProductEntity> joinProduct = root.join("productId");
				predicates.add(criteriaBuilder.equal(joinProduct.get("id"), filter.getProductId()));

			}
			if (filter.getFecha() != null) {
				predicates.add(
						criteriaBuilder.greaterThanOrEqualTo(root.<LocalDateTime>get("endDate"), filter.getFecha()));
				predicates.add(
						criteriaBuilder.lessThanOrEqualTo(root.<LocalDateTime>get("startDate"), filter.getFecha()));
			}
			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
