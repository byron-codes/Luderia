package br.com.byron.luderia.strategy.strategies;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import br.com.byron.luderia.model.Company;
import br.com.byron.luderia.strategy.exampleEntity.ICompanyCreateStrategy;
import br.com.byron.luderia.strategy.exampleEntity.ICompanyDeleteStrategy;
import br.com.byron.luderia.strategy.exampleEntity.ICompanyUpadateStrategy;

@Component
public class ExampleStrategy implements ICompanyCreateStrategy, ICompanyUpadateStrategy, ICompanyDeleteStrategy {

	@Override
	public Map<String, List<String>> execute(Company entity) {
		return new HashMap<String, List<String>>();
	}

}
