package it.daniele.medialogic.codfiscex.common.models;

import it.daniele.medialogic.codfiscex.common.utils.Constants;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import lombok.Data;

@Data
public class CFRequest {

    @NotEmpty(message = Constants.Messages.CF_ASSENTE)
    @Pattern(regexp = Constants.Regex.CF_REGEXP, message = Constants.Messages.CF_CHECK_KO)
    private String codiceFiscale;
}
