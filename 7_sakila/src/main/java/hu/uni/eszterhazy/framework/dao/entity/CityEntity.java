package hu.uni.eszterhazy.framework.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "city", schema = "sakila")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="city_id")
    private int id;

    @Column
    private String city;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity country;

    @Column(name="last_update")
    private Timestamp lastUpdate;

}
