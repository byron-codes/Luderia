package br.com.byron.luderia.repository;

import br.com.byron.luderia.domain.model.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends IGenericRepository<Comment> {

}
