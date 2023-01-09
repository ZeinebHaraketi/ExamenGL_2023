package tn.esprit.elmadhkournasreddine.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Setter(AccessLevel.NONE)
    Long idPatient;
    @Enumerated(EnumType.STRING)
    TypePieceIdentite typePieceIdentite;
    String identifiantPieceIdentite;
    Date dateEmission;
    String nomP;
    String prenomP;

    @JsonIgnore
    @ManyToMany
    Set<Pathologie> pathologies=new HashSet<>();




}
