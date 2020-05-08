package com.diego.companycontrol.client;

import com.diego.companycontrol.exception.HttpException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CPFClient {

    Logger logger = Logger.getLogger("CPFClient");

    public boolean validateCPF(String CPF){
        logger.log(Level.INFO, String.format("Starting to validate the CPF %s", CPF));
        try {
            RestTemplate restTemplate = new RestTemplateBuilder()
                    .rootUri("localhost:8080/validate")
                    .build();

            Boolean result = restTemplate.getForObject("/{cpf}", Boolean.TYPE , CPF);
            return result;

        } catch (Exception e){
            logger.log(Level.SEVERE, String.format("O Serviço de CPF está indisponível"));
            throw new HttpException("Serviço offline", HttpStatus.GATEWAY_TIMEOUT, "Errp");
        }
    }

}
