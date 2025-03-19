package springclass.sfgpetclinic.services;

import org.springframework.stereotype.Service;
import springclass.sfgpetclinic.model.Visit;

/**
 * @author : Jardel Brandão
 * @created : 19/03/2025
 **/
@Service
public interface VisitService extends CrudService<Visit, Long> {
}
