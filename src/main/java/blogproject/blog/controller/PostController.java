package blogproject.blog.controller;

import blogproject.blog.dto.request.CreatePostRequest;
import blogproject.blog.dto.request.UpdatePostRequest;
import blogproject.blog.service.CommentService;
import blogproject.blog.service.PostService;
import blogproject.blog.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class PostController {

    private final PostService postService;
    private final UserService userService;
    private final CommentService commentService;

    @GetMapping("/posts")
    public String showPosts(Model model) {
        model.addAttribute("posts", this.postService.getAllPosts());

        return "posts";
    }

    @GetMapping("/create-post")
    public String showCreatePost(Model model) {
        model.addAttribute("post", new CreatePostRequest());
        model.addAttribute("users", this.userService.getAllUsers());

        return "create_post";
    }

    @PostMapping("/create-post")
    public String createPost(@ModelAttribute("post") CreatePostRequest createPostRequest) {
        this.postService.createPost(createPostRequest);

        return "redirect:/posts";
    }

    @GetMapping("/post/{id}")
    public String showPostDetail(@PathVariable Long id, Model model) {
        model.addAttribute("post",this.postService.getPostById(id));
        model.addAttribute("comments",this.commentService.getAllCommentsByPostId(id));

        return "post_detail";
    }

    @GetMapping("/update-post/{id}")
    public String showUpdatePost(@PathVariable Long id, Model model) {
        model.addAttribute("post", this.postService.getPostById(id));


        return "update_post";
    }

    @PostMapping("/update-post/{id}")
    public String updatePost(@ModelAttribute("post") UpdatePostRequest updatePostRequest) {

        this.postService.updatePost(updatePostRequest);

        return "redirect:/posts";
    }

    @GetMapping("/delete-post/{id}")
    public String deletePost(@PathVariable Long id) {
        this.postService.deletePostById(id);

        return "redirect:/posts";
    }

}
