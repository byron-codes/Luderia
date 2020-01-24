package br.com.byron.luderia.repository.specification;

import java.lang.reflect.Field;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.byron.luderia.dto.filter.GenericFilter;
import br.com.byron.luderia.model.GenericEntity;

public abstract class GenericSpecification<Entity extends GenericEntity, Filter extends GenericFilter> implements Specification<Entity> {

	private static final long serialVersionUID = 1L;

	protected void add(Predicate predicate, Expression<Boolean> expression) {
		predicate.getExpressions().add(expression);
	}

	protected Field[] concatenate(Field[] a, Field[] b) {
		Field[] fields = new Field[a.length + b.length];
		System.arraycopy(a, 0, fields, 0, a.length);
		System.arraycopy(b, 0, fields, a.length, b.length);
		return fields;
	}

	// Fields name in filter be like domain class
	protected void generateBasicPredicate(Predicate predicate, Filter filter, Root<Entity> root,
			CriteriaBuilder criteriaBuilder) {

		Field[] oFields = filter.getClass().getDeclaredFields();
		Field[] sFields = filter.getClass().getSuperclass().getDeclaredFields();

		Field[] fields = concatenate(oFields, sFields);

		for (int i = 0; i < fields.length; i++) {
			try {
				fields[i].setAccessible(true);
				Object field = fields[i].get(filter);
				if (field != null) {
					if ((fields[i].getType().equals(String.class) || fields[i].getType().equals(Character.class))
							&& (!fields[i].toString().trim().isEmpty())) {
						add(predicate, criteriaBuilder.like(root.get(fields[i].getName()), "%" + field + "%"));
					} else {
						add(predicate, criteriaBuilder.trim(root.get(fields[i].getName())).in(field.toString()));
					}
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}

	}

}
