package br.com.byron.luderia.domain.model;

import br.com.byron.luderia.domain.enumerable.ChangeReason;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Where(clause = "active=true")
@Table(name = "_sale_change_item")
public class SaleChangeItem extends GenericEntity {

	@Column
	private Boolean authorized;

	@Column
	private Integer quantity;

	@Column
	@Enumerated(EnumType.STRING)
	private ChangeReason changeReason;

	@Column
	private String description;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "product")
	private Product product;

}
