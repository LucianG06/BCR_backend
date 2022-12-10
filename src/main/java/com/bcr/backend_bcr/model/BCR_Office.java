package com.bcr.backend_bcr.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "office")
public class BCR_Office {

    @Id
    private Integer orgId;

    @NotNull
    private String nume;

    @NotNull
    private String strada;

    @NotNull
    private String oras;

    @NotNull
    private String telefon;

    @NotNull
    private String latitudine;

    @NotNull
    private String longitudine;

    @NotNull
    private String deschis;

}
