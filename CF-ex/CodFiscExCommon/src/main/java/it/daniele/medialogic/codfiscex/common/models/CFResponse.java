package it.daniele.medialogic.codfiscex.common.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CFResponse{

    private Integer eta;
    private LocalDate dataNascita;


}
