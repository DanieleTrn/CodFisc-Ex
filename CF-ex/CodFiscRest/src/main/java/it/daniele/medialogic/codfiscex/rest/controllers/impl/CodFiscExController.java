package it.daniele.medialogic.codfiscex.rest.controllers.impl;

import it.daniele.medialogic.codfiscex.common.exceptions.CodFiscExServiceException;
import it.daniele.medialogic.codfiscex.common.models.CFRequest;
import it.daniele.medialogic.codfiscex.common.models.CFResponse;
import it.daniele.medialogic.codfiscex.rest.controllers.interfaces.ICodFiscExController;

import it.daniele.medialogic.codfiscex.rest.services.interfaces.ICodFiscExService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cod-fiscale")
public class CodFiscExController implements ICodFiscExController {

    @Autowired
    ICodFiscExService cfService;

    @Override
    @PostMapping("get-info")
    public ResponseEntity<CFResponse> getInfoByCf(@RequestBody CFRequest request) throws CodFiscExServiceException {
            CFResponse responseBody = cfService.getInfoByCf(request);
            return ResponseEntity.ok().body(responseBody);
    }

    @ExceptionHandler(CodFiscExServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<List<String>> handleValidationExceptions(CodFiscExServiceException ex) {
        return ResponseEntity.badRequest().body(ex.getErrorList());
    }
}
