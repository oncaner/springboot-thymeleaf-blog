package blogproject.blog.service.impl;

import blogproject.blog.config.mapper.ModelMapperService;
import blogproject.blog.dto.request.CreatePostRequest;
import blogproject.blog.dto.request.UpdatePostRequest;
import blogproject.blog.dto.response.PostDto;
import blogproject.blog.model.Post;
import blogproject.blog.repository.PostRepository;
import blogproject.blog.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = this.postRepository.findAll();

        return posts.stream()
                .map(post -> this.modelMapperService.forResponse()
                        .map(post, PostDto.class)).toList();
    }

    @Override
    public PostDto getPostById(Long id) {
        Post post = this.postRepository.findById(id).orElseThrow();

        return this.modelMapperService.forResponse().map(post, PostDto.class);
    }

    @Override
    public void createPost(CreatePostRequest createPostRequest) {
        Post post = this.modelMapperService.forRequest().map(createPostRequest, Post.class);
        post.setId(0L);

        this.postRepository.save(post);
    }

    @Override
    public void updatePost(UpdatePostRequest updatePostRequest) {
        Post post = this.modelMapperService.forRequest().map(updatePostRequest, Post.class);

        this.postRepository.save(post);
    }

    @Override
    public void deletePostById(Long id) {
        this.postRepository.deleteById(id);
    }
}
