package tn.esprit.elmadhkournasreddine.Entities;

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
public class FamilleActe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Setter(AccessLevel.NONE)
    Long idFA;
    String codeFA;
    String libelle;
    String description;

    @OneToMany(mappedBy = "familleActe",cascade = CascadeType.ALL)
    Set<Acte> actes=new HashSet<>();
}
