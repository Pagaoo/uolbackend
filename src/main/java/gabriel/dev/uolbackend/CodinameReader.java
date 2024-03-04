package gabriel.dev.uolbackend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import gabriel.dev.uolbackend.enities.Hero;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Getter
public class CodinameReader {

    private final Environment environment;
    private final RestTemplate restTemplate;

    private final List<String> ligaJusticaCodinames = new ArrayList<>();
    private final List<String> vingadoresCodinames = new ArrayList<>();

    ObjectMapper object = new ObjectMapper();

    public CodinameReader(Environment environment, RestTemplate restTemplate) {
        this.environment = environment;
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    public void xmlReader() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(environment.getProperty("liga.justica"));

            NodeList listaCodiname = document.getElementsByTagName("codinome");

            for (int i = 0; i < listaCodiname.getLength(); i++) {
                Element elements = (Element) listaCodiname.item(i);
                String codiname = elements.getTextContent();
                this.ligaJusticaCodinames.add(codiname);
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostConstruct
    public void jsonReader() {
        try {
            String codiname = restTemplate.getForObject(Objects.requireNonNull(environment.getProperty("vingadores")), String.class);
            JsonNode jsonNode = object.readTree(codiname);

            ArrayNode vingadores = (ArrayNode) jsonNode.get("vingadores");

            for (JsonNode item: vingadores) {
                this.vingadoresCodinames.add(item.get("codinome").asText());
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
