package blogproject.blog.service;

import blogproject.blog.dto.request.CreatePostRequest;
import blogproject.blog.dto.request.UpdatePostRequest;
import blogproject.blog.dto.response.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> getAllPosts();

    PostDto getPostById(Long id);

    void createPost(CreatePostRequest createPostRequest);

    void updatePost(UpdatePostRequest updatePostRequest);

    void deletePostById(Long id);
}
