package br.com.byron.luderia.service;

import br.com.byron.luderia.dto.filter.ExpansionFilter;
import br.com.byron.luderia.dto.filter.GameFilter;
import br.com.byron.luderia.model.Expansion;
import br.com.byron.luderia.model.Game;
import br.com.byron.luderia.repository.IExpansionRepository;
import br.com.byron.luderia.repository.IGameRepository;
import br.com.byron.luderia.repository.specification.ExpansionSpecification;
import br.com.byron.luderia.repository.specification.GameSpecification;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class ExpansionService extends GenericService<Expansion, ExpansionFilter> {

    private IExpansionRepository repository;

    ExpansionService(IExpansionRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public List<Expansion> find(ExpansionFilter filter) {
        return repository.findAll(new ExpansionSpecification(filter));
    }

}
