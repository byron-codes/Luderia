package br.com.byron.luderia.domain.request;

import br.com.byron.luderia.domain.filter.UserFilter;
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
