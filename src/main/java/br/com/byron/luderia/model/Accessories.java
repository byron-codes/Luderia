package br.com.byron.luderia.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Getter
@Setter
@Entity
@NoArgsConstructor
@DiscriminatorValue("ACCESSORIES")
@PrimaryKeyJoinColumn(name = "id_product")
@Table(name = "_accessories")
@Where(clause = "active=true")
public class Accessories extends Product {

}
