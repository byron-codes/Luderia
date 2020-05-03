package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.dto.filter.GenericFilter;
import br.com.byron.luderia.model.GenericEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;

@Setter
@Getter
public abstract class GenericSpecification<Entity extends GenericEntity, Filter extends GenericFilter> implements Specification<Entity> {

    private Filter filter;

    protected void add(Predicate predicate, Expression<Boolean> expression) {
        predicate.getExpressions().add(expression);
    }

    protected Field[] concatenate(Field[] a, Field[] b) {
        Field[] fields = new Field[a.length + b.length];
        System.arraycopy(a, 0, fields, 0, a.length);
        System.arraycopy(b, 0, fields, a.length, b.length);
        return fields;
    }

    protected Field[] concatenate(Field[] a, Field x) {
        Field[] b = new Field[1];
        b[0] = x;
        Field[] fields = new Field[a.length + b.length];
        System.arraycopy(a, 0, fields, 0, a.length);
        System.arraycopy(b, 0, fields, a.length, b.length);
        return fields;
    }

    private Field[] getClassFields(Entity entity) {
        Field[] allFields = entity.getClass().getDeclaredFields();
        Class<?> clazz = entity.getClass().getSuperclass();

        while (!clazz.equals(Object.class)) {
            allFields = concatenate(allFields, clazz.getDeclaredFields());
            clazz = clazz.getSuperclass();
        }
        return allFields;
    }

    private Field[] getClassFields(Filter entity) {
        Field[] allFields = entity.getClass().getDeclaredFields();
        Class<?> clazz = entity.getClass().getSuperclass();

        while (!clazz.equals(Object.class)) {
            allFields = concatenate(allFields, clazz.getDeclaredFields());
            clazz = clazz.getSuperclass();
        }
        return allFields;
    }

    private boolean verifyText(Field field) {
        return (field.getType().equals(String.class) || field.getType().equals(Character.class))
                && (!field.toString().trim().isEmpty());
    }

    private boolean verifyBoolean(Field field) {
        return (field.getType().equals(Boolean.class));
    }

    // OS NOMES DO FILTRO DEVEM ESTAR IGUAIS A CLASSE DE DOMINIO
    protected void generateBasicPredicate(Predicate predicate, Filter filter, Root<Entity> root,
                                          CriteriaBuilder criteriaBuilder, Entity entityToClass) {

        //FIELDS DA CLASSE DE DOMINIO
        Field[] allDomainFields = getClassFields(entityToClass);

        //FIELDS DA CLASSE DE FILTRO
        Field[] allFilterFields = getClassFields(filter);

        //EXCLUSAO DE CAMPOS QUE NAO EXISTEM NA DOMINIO
        Field[] fields = new Field[0];
        for (int i = 0; i < allFilterFields.length; i++) {
            for (int k = 0; k < allDomainFields.length; k++) {
                if (allDomainFields[k].getName().equals(allFilterFields[i].getName())) {
                    fields = concatenate(fields, allFilterFields[i]);
                    break;
                }
            }
        }

        //CRIACAO DO SPECIFICATION
        for (int i = 0; i < fields.length; i++) {
            try {
                fields[i].setAccessible(true);
                Object field = fields[i].get(filter);
                if (field != null) {
                    //CASO SEJA TEXTO
                    if (verifyText(fields[i])) {
                        add(predicate, criteriaBuilder.like(root.get(fields[i].getName()), "%" + field + "%"));
                        //CASO SEJA BOOLEAN
                    } else if(verifyBoolean(fields[i])) {
                        //TRUE
                        if(Boolean.valueOf(field.toString())) {
                            add(predicate, criteriaBuilder.isTrue(root.get(fields[i].getName())));
                            //FALSE
                        } else {
                            add(predicate, criteriaBuilder.isFalse(root.get(fields[i].getName())));
                        }
                        //OUTROS CASOS
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
