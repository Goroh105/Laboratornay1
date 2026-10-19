package com.dolsoft.proizvoditelservice.service;

import com.dolsoft.proizvoditelservice.model.Proizvoditel;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ProizvoditelService {

    public Proizvoditel getProizvoditel(String proizvoditelId) {
        Proizvoditel proizvoditel = new Proizvoditel();
        proizvoditel.setId(new Random().nextInt(1000));
        proizvoditel.setName("ООО Ромашка");
        proizvoditel.setCountry("Россия");
        proizvoditel.setContactPerson("Иванов Иван");
        proizvoditel.setPhone("+7 (999) 123-45-67");
        return proizvoditel;
    }

    public String createProizvoditel(Proizvoditel proizvoditel) {
        String responseMessage = null;
        if (proizvoditel != null) {
            responseMessage = String.format(
                    "This is the post and the object is: %s", proizvoditel.toString());
        }
        return responseMessage;
    }

    public String updateProizvoditel(Proizvoditel proizvoditel) {
        String responseMessage = null;
        if (proizvoditel != null) {
            responseMessage = String.format(
                    "This is the put and the object is: %s", proizvoditel.toString());
        }
        return responseMessage;
    }

    public String deleteProizvoditel(String proizvoditelId) {
        return String.format("Deleting proizvoditel with id %s", proizvoditelId);
    }
}