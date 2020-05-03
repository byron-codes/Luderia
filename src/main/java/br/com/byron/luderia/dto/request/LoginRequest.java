package br.com.byron.luderia.dto.request;

import br.com.byron.luderia.dto.filter.UserFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest extends UserFilter{

    private String nickname;

    private String password;

}
