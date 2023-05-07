package blogproject.blog.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    @NotNull(message = "Bu alanı doldurunuz!")
    @NotBlank(message = "Boş geçilemez!")
    @Size(min = 3, max = 50, message = "Ad 3 ile 50 arasında olmak zorunda!")
    private String firstName;

    @NotNull(message = "Bu alanı doldurunuz!")
    @NotBlank(message = "Boş geçilemez!")
    @Size(min = 2, max = 50, message = "Soyad 3 ile 50 arasında olmak zorunda!")
    private String lastName;

    @NotNull(message = "Bu alanı doldurunuz!")
    @NotBlank(message = "Boş geçilemez!")
    @Size(min = 3, max = 10, message = "Kullanıcı Adı 3 ile 50 arasında olmak zorunda!")
    private String nickname;

    @NotNull(message = "Bu alanı doldurunuz!")
    @NotBlank(message = "Boş geçilemez!")
    @Size(min = 5, max = 30, message = "Şifre 5 ile 50 arasında olmak zorunda!")
    private String password;
    @NotNull
    @NotBlank
    private String email;


}
