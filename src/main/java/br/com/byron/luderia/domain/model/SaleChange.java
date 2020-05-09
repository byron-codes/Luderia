package br.com.byron.luderia.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_sale_change")
@Where(clause = "active=true")
public class SaleChange extends GenericEntity {

	@Column
	@Enumerated(EnumType.STRING)
	private ChangeStatus changeStatus;

	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "coupon")
	private Coupon coupon;

	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "sale")
	private Sale sale;

	@OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinTable(joinColumns = {
			@JoinColumn(name = "sale_change_id", referencedColumnName = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "sale_change_item_id", referencedColumnName = "id") })
	private List<SaleChangeItem> items = new ArrayList<>();

}
