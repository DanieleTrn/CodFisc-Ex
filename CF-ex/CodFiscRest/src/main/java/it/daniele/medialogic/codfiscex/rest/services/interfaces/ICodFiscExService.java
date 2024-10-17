package it.daniele.medialogic.codfiscex.rest.services.interfaces;

import it.daniele.medialogic.codfiscex.common.exceptions.CodFiscExServiceException;
import it.daniele.medialogic.codfiscex.common.models.CFRequest;
import it.daniele.medialogic.codfiscex.common.models.CFResponse;

public interface ICodFiscExService {

    CFResponse getInfoByCf(CFRequest request) throws CodFiscExServiceException;
}
