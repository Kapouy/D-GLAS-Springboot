
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Taches périodiques (synchronisation entrant/sortant, gestion d'erreurs).
 */
@Component
public class ScheduledTasks {

//  @Autowired
//  NetEntreprisePublisher netEntreprisePublisher;

//  @Autowired
//  NetEntrepriseFetcher netEntrepriseFetcher;

  @Value("${publish.enabled:true}")
  boolean publishNetEntrepriseEvtEnabled;

  @Value("${fetch.enabled:true}")
  boolean fetchNetEntrepriseEvtEnabled;

  /**
   * Envois de DSN à Net Entreprise.
   */
  @Scheduled(fixedDelayString = "${publish.delay}")
  public void publishOnNetEntreprise() {

  }

  /**
   * Listing des depots sur Net Entreprise.
   */
  @Scheduled(fixedDelayString = "${fetch.delay}")
  public void fetchFromNetEntreprise() {

  }

}
