package br.com.byron.luderia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.byron.luderia.dto.filter.CommentFilter;
import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.model.Comment;
import br.com.byron.luderia.repository.ICommentRepository;
import br.com.byron.luderia.repository.specification.CommentSpecification;

@Service
public class CommentService extends GenericService<Comment, CommentFilter> {

	private ICommentRepository repository;

	private SaleAdService saleAdService;

	CommentService(ICommentRepository repository, SaleAdService saleAdService) {
		super(repository);
		this.repository = repository;
		this.saleAdService = saleAdService;
	}

	@Override
	public List<Comment> find(CommentFilter filter) {
		List<Comment> entities = repository.findAll(new CommentSpecification(filter));
		if (entities.isEmpty()) {
			throw new NotFoundEntityException("Entity not found");
		}
		return entities;
	}

	@Override
	public Comment add(Comment entity) {
		Comment comment = super.add(entity);
		entity.setSaleAd(saleAdService.find(entity.getSaleAd()));
		entity.getSaleAd().getComments().add(comment);
		saleAdService.update(comment.getSaleAd());
		return comment;
	}

}
