package br.com.byron.luderia.domain.model;

import br.com.byron.luderia.domain.enumerable.GameLevel;
import br.com.byron.luderia.domain.enumerable.GameStyle;
import br.com.byron.luderia.domain.enumerable.GameType;
import br.com.byron.luderia.domain.enumerable.LanguageDependence;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("GAME")
@PrimaryKeyJoinColumn(name = "id_product")
@Where(clause = "active=true")
@Table(name = "_game")
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

}
