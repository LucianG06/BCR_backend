package com.bcr.backend_bcr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {
    private String email_rec;
    private String denumireLocatie;
    private Double latitudine;
    private Double longitudine;
    private String strada;
    private String data;
    private String ora;
}
