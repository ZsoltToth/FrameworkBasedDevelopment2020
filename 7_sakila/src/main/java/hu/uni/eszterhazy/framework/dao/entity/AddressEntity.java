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
@Table(name = "address", schema = "sakila")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="address_id")
    private int id;

    @Column
    private String address;
    @Column
    private String address2;
    @Column
    private String district;

    @OneToOne
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    private CityEntity city;

    @Column(name="postal_code")
    private String postalCode;
    @Column
    private String phone;

    //    Geomerty type; See: https://stackoverflow.com/questions/39147145/spring-data-jpa-and-geometry-type
//    Implement later
//    private location
    @Column(name="last_update")
    private Timestamp lastUpdate;

}
