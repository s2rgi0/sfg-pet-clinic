package xerfio.springframework.sfgpetclinic.model;

import lombok.Builder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


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

    public Owner(Long id, String firstName, String lastName, String address) {
        super(id, firstName, lastName);
        this.address = address;
    }

    public Owner(Long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    public Owner() {
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getTelephone() {
        return telephone;
    }

    public Set<Pet> getPets() {
        return pets;
    }

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
