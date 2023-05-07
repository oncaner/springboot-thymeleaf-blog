package blogproject.blog.service;

import blogproject.blog.dto.request.CreateCommentRequest;
import blogproject.blog.dto.response.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> getAllComments();

    List<CommentDto> getAllCommentsByPostId(Long id);

    CommentDto getCommentById(Long id);

    void createComment(CreateCommentRequest createCommentRequest);

    void deleteCommentById(Long id);

}
