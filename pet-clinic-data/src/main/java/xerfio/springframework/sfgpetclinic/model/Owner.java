package xerfio.springframework.sfgpetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Builder
    public Owner(Long id,String firstName, String lastName, String address, String city, String telephone, Set<Pet> pets) {
        super(id,firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }


    @Column(name = "addres")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();


    @Override
    public String toString() {
        return   "Owner{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", telephone='" + telephone + '\'' +
                ", pets=" + pets +", " +super.toString()+
                '}';
    }
}
