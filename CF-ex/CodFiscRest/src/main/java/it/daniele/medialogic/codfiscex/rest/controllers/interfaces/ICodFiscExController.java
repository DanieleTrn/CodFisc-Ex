package it.daniele.medialogic.codfiscex.rest.controllers.interfaces;


import it.daniele.medialogic.codfiscex.common.exceptions.CodFiscExServiceException;
import it.daniele.medialogic.codfiscex.common.models.CFRequest;
import it.daniele.medialogic.codfiscex.common.models.CFResponse;

import org.springframework.http.ResponseEntity;

public interface ICodFiscExController {

    ResponseEntity<CFResponse> getInfoByCf(CFRequest request) throws CodFiscExServiceException;
}
