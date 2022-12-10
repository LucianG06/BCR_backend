package com.bcr.backend_bcr.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
