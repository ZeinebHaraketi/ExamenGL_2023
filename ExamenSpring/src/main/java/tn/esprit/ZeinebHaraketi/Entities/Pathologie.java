package tn.esprit.elmadhkournasreddine.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Pathologie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Setter(AccessLevel.NONE)
    Long idPath;
    String codePath;
    String libelle;
    String description;

    Boolean archive=false;

    @JsonIgnore
    @ManyToMany
    Set<Acte> actes=new HashSet<>();



}
