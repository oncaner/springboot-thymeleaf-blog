package blogproject.blog.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePostRequest {

    private Long id;

    private String title;

    private String content;

    private Long userId;

}
