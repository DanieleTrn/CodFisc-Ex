package it.daniele.medialogic.codfiscex.common.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class CodFiscExServiceException extends Throwable {

    List<String> errorList;

    public CodFiscExServiceException(List<String> errorList){
        this.errorList = errorList;
    }

    public CodFiscExServiceException(String message){
        getErrorList().add(message);
    }

    public List<String> getErrorList(){
        if(this.errorList == null){
            this.errorList = new ArrayList<>();
        }

        return this.errorList;
    }
}
