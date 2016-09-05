package ua.oril.pv.service;

import org.springframework.stereotype.Service;
import ua.oril.pv.entity.Domain;

import java.io.IOException;

/**
 * Created by pevsat on 02.09.2016.
 */
@Service
public interface DomainService extends BaseService<Domain> {
    public void addDomain(Domain domain) throws IOException;
}
