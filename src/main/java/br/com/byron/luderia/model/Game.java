package br.com.byron.luderia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("GAME")
@PrimaryKeyJoinColumn(name = "id_product")
@Table(name = "_game")
@Where(clause = "active=true")
public class Game extends Product {

	@Column
	private String originalName;

	@Column
	private String components;

	@Column
	private LocalDate releaseDate;

	@Column
	private Integer minPlayers;

	@Column
	private Integer maxPlayers;

	@Column
	private Integer minMinutes;

	@Column
	private Integer maxMinutes;

	@Column
	private Integer minAge;

	@Column
	private Boolean national;

	@Column
	private Double avaliation;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "company")
	private Company company;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "game_system")
	private GameSystem system;

	@Column
	@Enumerated(EnumType.STRING)
	private LanguageDependence languageDependence;

	@Column
	@Enumerated(EnumType.STRING)
	private GameStyle style;

	@Column
	@Enumerated(EnumType.STRING)
	private GameType type;

	@Column
	@Enumerated(EnumType.STRING)
	private GameLevel level;

	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<Award> awards = new ArrayList<Award>();

	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<Designer> designers = new ArrayList<Designer>();

	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<Author> authors = new ArrayList<Author>();

	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<Theme> themes = new ArrayList<Theme>();

	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<GameCategory> categories = new ArrayList<GameCategory>();

	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<SleeveModel> sleeves = new ArrayList<SleeveModel>();

	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<Mechanic> mechanics = new ArrayList<Mechanic>();

}
