package com.olhonoponto;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("numeroPonto")
public class JsoupController {

    @PostMapping
    public ResponseEntity<?> pontoDeOnibus(@RequestBody PontoDeOnibus pontoDeOnibus) {
        String url = "https://weather.com/weather/today/l/9ed607652efdaf60603c7a9f34933f2b181b4c6f072d88474779ce85afd261ad";
        try {//<span data-testid="TemperatureValue" class="CurrentConditions--tempValue--3KcTQ">20°</span> <div data-testid="precipPhrase" class="CurrentConditions--precipValue--RBVJT"><span>2% chance of rain through 11 pm</span></div> <div data-testid="wxPhrase" class="CurrentConditions--phraseValue--2xXSr">Fair</div>
            Document doc = Jsoup.connect(url).get();//<div class="CurrentConditions--timestamp--1SWy5">As of 10:49 pm BRT</div>
            Elements cidade = doc.getElementsByTag("span").attr("class", "styles--locationName--GkM1S");
            
            for(Element ele : cidade) {
                if(ele.text().contains("Brazil")) {
                    System.out.println(ele.text());
                }
            }

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> infoTempo() {
        InformacaoTempo informacaoTempo = new InformacaoTempo();
        
        try {
            String urlGF = "https://www.cptec.inpe.br/previsao-tempo/go/goiania";
            Document doc = Jsoup.connect(urlGF).get();
            Elements label = doc.select("div > strong");
            Elements value = doc.select("div > span");
            
            informacaoTempo.setSiteDeReferencia(value.get(0).text());
            informacaoTempo.setManha("Umidade do Ar "+value.get(2).text()+" "+value.get(1).text());
            informacaoTempo.setTarde("Umidade do Ar "+value.get(4).text()+" "+value.get(3).text());
            informacaoTempo.setNoite("Umidade do Ar "+value.get(6).text()+" "+value.get(5).text());
            informacaoTempo.setTemperaturaMinima("Temperatura mínima"+" "+value.get(7).text());
            informacaoTempo.setTemperaturaMaxima("Temperatura máxima"+" "+value.get(8).text());
            informacaoTempo.setNascerDoSol(label.get(0).text()+" "+value.get(9).text());
            informacaoTempo.setPorDoSol(label.get(1).text()+" "+value.get(10).text());
            informacaoTempo.setIuvMaximo(label.get(2).text()+" "+value.get(11).text());
            return ResponseEntity.ok(informacaoTempo);

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}