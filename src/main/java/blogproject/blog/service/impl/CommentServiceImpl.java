package blogproject.blog.service.impl;

import blogproject.blog.config.mapper.ModelMapperService;
import blogproject.blog.dto.request.CreateCommentRequest;
import blogproject.blog.dto.response.CommentDto;
import blogproject.blog.model.Comment;
import blogproject.blog.repository.CommentRepository;
import blogproject.blog.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<CommentDto> getAllComments() {
        List<Comment> comments = this.commentRepository.findAll();

        return comments.stream()
                .map(comment -> this.modelMapperService.forResponse()
                        .map(comment, CommentDto.class)).toList();
    }

    @Override
    public List<CommentDto> getAllCommentsByPostId(Long id) {
        List<Comment> comments = this.commentRepository.findAllByPostId(id);

        return comments.stream()
                .map(comment -> this.modelMapperService.forResponse()
                        .map(comment, CommentDto.class)).toList();
    }

    @Override
    public CommentDto getCommentById(Long id) {
        Comment comment = this.commentRepository.findById(id).orElseThrow();

        return this.modelMapperService.forResponse().map(comment, CommentDto.class);
    }

    @Override
    public void createComment(CreateCommentRequest createCommentRequest) {
        Comment comment = this.modelMapperService.forRequest().map(createCommentRequest, Comment.class);

        this.commentRepository.save(comment);
    }

    @Override
    public void deleteCommentById(Long id) {
        this.commentRepository.deleteById(id);
    }
}
