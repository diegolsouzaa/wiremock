package br.com.balatech.addressregister.service;

import br.com.balatech.addressregister.bean.ZipCodeResponse;
import br.com.balatech.addressregister.config.CEPConfig;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;

import static java.util.Collections.get;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("mock")
public class AddressServiceTest {

    private AddressService addressService;

    @Autowired
    private CEPConfig cepConfig;



    @Rule
    private WireMockRule wireMockRule = new WireMockRule(8082);

    @Before
    void setUp() {

        RestTemplate restTemplate = new RestTemplateBuilder().build();
        addressService = new AddressService(restTemplate,cepConfig);
    }
    @Test
    public void listAddresByZipCodeSucess(){
//        wireMockRule.stubFor(get(urlPathEqualTo("/ws/12345678/json").willReturn()))
        ZipCodeResponse zipCodeResponse = addressService.getAddressByZipCode("12345678");
        Assert.assertNotNull(zipCodeResponse);


    }


}