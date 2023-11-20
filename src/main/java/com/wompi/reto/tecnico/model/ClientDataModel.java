package com.wompi.reto.tecnico.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClientDataModel {
    private String strCorreo;
    private String strNameAndLastName;
    private String phoneNumber;

    private  String cedulaCiudadania;


    public  static List<ClientDataModel> setData(DataTable dataTable){
        List<ClientDataModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for(Map<String, String> map: mapInfo)
        {
            dates.add(new ObjectMapper().convertValue(map, ClientDataModel.class));
        }
        return  dates;
    }

    public String getStrCorreo() {
        return strCorreo;
    }

    public void setStrCorreo(String strCorreo) {
        this.strCorreo = strCorreo;
    }

    public String getStrNameAndLastName() {
        return strNameAndLastName;
    }

    public void setStrNameAndLastName(String strNameAndLastName) {
        this.strNameAndLastName = strNameAndLastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCedulaCiudadania() {
        return cedulaCiudadania;
    }

    public void setCedulaCiudadania(String cedulaCiudadania) {
        this.cedulaCiudadania = cedulaCiudadania;
    }
}
