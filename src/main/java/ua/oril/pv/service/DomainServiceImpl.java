package ua.oril.pv.service;

import org.springframework.stereotype.Service;
import ua.oril.pv.entity.Domain;

/**
 * Created by pevsat on 02.09.2016.
 */
@Service
public class DomainServiceImpl extends BaseServiceImpl<Domain>  implements DomainService{
    /*@Autowired
    DomainDao domainDao;

    @Override
    public List<Domain> findAll(){
        return domainDao.findAll();
    }*/
}
