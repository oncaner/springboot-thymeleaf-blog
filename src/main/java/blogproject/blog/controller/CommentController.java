package blogproject.blog.controller;

import blogproject.blog.dto.request.CreateCommentRequest;
import blogproject.blog.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/post/comment")
    public String showCommentForm(Model model) {
        model.addAttribute("comment", new CreateCommentRequest());

        return "add_comment";
    }

    @PostMapping("/post/comment")
    public String createComment(@ModelAttribute("comment") CreateCommentRequest createCommentRequest) {
        this.commentService.createComment(createCommentRequest);

        return "redirect:/post/{id}";
    }

}
