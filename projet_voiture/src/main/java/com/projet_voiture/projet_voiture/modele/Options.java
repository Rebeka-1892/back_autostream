package com.projet_voiture.projet_voiture.modele;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Options {
    @Id
    int idoptions;
    String nomoptions;
    int idtype;

    public Options() {
    }

    public Options(int idoptions, String nomoptions, int idtype) {
        this.idoptions = idoptions;
        this.nomoptions = nomoptions;
        this.idtype = idtype;
    }

    public int getIdoptions() {
        return idoptions;
    }
    public void setIdoptions(int idoptions) {
        this.idoptions = idoptions;
    }
    public String getNomoptions() {
        return nomoptions;
    }
    public void setNomoptions(String nomoptions) {
        this.nomoptions = nomoptions;
    }
    public int getIdtype() {
        return idtype;
    }
    public void setIdtype(int idtype) {
        this.idtype = idtype;
    }
    
}
