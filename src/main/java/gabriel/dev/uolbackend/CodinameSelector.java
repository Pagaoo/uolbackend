package gabriel.dev.uolbackend;

import gabriel.dev.uolbackend.enities.HeroGroup;
import org.springframework.stereotype.Component;

@Component
public class CodinameSelector {

    private final CodinameReader codinameReader;

    public CodinameSelector(CodinameReader codinameReader) {
        this.codinameReader = codinameReader;
    }

    public String selectCodiname(HeroGroup heroGroup) {
        if (heroGroup == HeroGroup.LIGA_DA_JUSTICA) {
            String codiname = codinameReader.getLigaJusticaCodinames().stream().findFirst().orElseThrow();
            this.codinameReader.getLigaJusticaCodinames().remove(codiname);
            return codiname;
        }
        String codiname = codinameReader.getVingadoresCodinames().stream().findFirst().orElseThrow();
        this.codinameReader.getVingadoresCodinames().remove(codiname);
        return codiname;
    }
}
