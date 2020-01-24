package br.com.byron.luderia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.byron.luderia.dto.filter.ThemeFilter;
import br.com.byron.luderia.model.Theme;
import br.com.byron.luderia.repository.IThemeRepository;
import br.com.byron.luderia.repository.specification.ThemeSpecification;

@Service
public class ThemeService extends GenericService<Theme, ThemeFilter> {

	private IThemeRepository repository;
	
	ThemeService(IThemeRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<Theme> find(ThemeFilter filter) {
		return repository.findAll(new ThemeSpecification(filter));
	}

}
