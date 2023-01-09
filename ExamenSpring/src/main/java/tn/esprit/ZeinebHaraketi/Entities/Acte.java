package tn.esprit.elmadhkournasreddine.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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
public class Acte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Setter(AccessLevel.NONE)
    Long idActe;
    String codeActe;
    int cotationActe;
    float prixUnitaireActe;
    String designationActe;

    @ManyToMany(mappedBy = "actes")
    Set<Pathologie> pathologies=new HashSet<>();

    @JsonIgnore
    @ManyToOne
    FamilleActe familleActe;




}
