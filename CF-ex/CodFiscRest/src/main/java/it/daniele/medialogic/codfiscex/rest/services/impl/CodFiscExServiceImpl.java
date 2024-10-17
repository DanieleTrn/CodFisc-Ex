package it.daniele.medialogic.codfiscex.rest.services.impl;

import it.daniele.medialogic.codfiscex.common.exceptions.CodFiscExServiceException;
import it.daniele.medialogic.codfiscex.common.models.CFRequest;
import it.daniele.medialogic.codfiscex.common.models.CFResponse;
import it.daniele.medialogic.codfiscex.common.utils.Constants;
import it.daniele.medialogic.codfiscex.rest.services.interfaces.ICodFiscExService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;

@Service
public class CodFiscExServiceImpl implements ICodFiscExService {

    @Override
    public CFResponse getInfoByCf(CFRequest request) throws CodFiscExServiceException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<CFRequest>> violations = validator.validate(request);

        if (!violations.isEmpty()) {
            List<String> errors = violations.stream()
                                  .map(ConstraintViolation::getMessage)
                                  .toList();

            throw new CodFiscExServiceException(errors);
        }

        CFResponse retVal = new CFResponse();

        String codiceFiscale = request.getCodiceFiscale();

        int anno = getAnnoFromCf(Integer.parseInt(codiceFiscale.substring(6,8)));
        int mese = Constants.UtilityConstants.CF_MONTHS_MAP.get(codiceFiscale.substring(8,9));
        int giorno = Integer.parseInt(codiceFiscale.substring(9, 11));

        if(giorno > 31){
            giorno -= 40;
            if(giorno < 1 || giorno > 31){
                throw new CodFiscExServiceException(Constants.Messages.CF_CHECK_KO);
            }
        }

        try {
            LocalDate dataNascita = LocalDate.of(anno, mese, giorno);
            int eta = Period.between(dataNascita, LocalDate.now()).getYears();

            retVal.setEta(eta);
            retVal.setDataNascita(dataNascita);

            return retVal;
        } catch(DateTimeException ex){
            throw new CodFiscExServiceException(Constants.Messages.DATE_KO);
        }

    }

    public Integer getAnnoFromCf(Integer annoUtente){
        int currYearAA = LocalDate.now().getYear() - 2000;

        return currYearAA > annoUtente ? 2000 + annoUtente : 1900 + annoUtente;
    }
}
