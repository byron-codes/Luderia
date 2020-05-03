package br.com.byron.luderia.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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
