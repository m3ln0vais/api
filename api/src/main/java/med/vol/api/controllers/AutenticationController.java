package med.vol.api.controllers;

import jakarta.validation.Valid;
import med.vol.api.infra.security.TokenDTO;
import med.vol.api.infra.security.TokenService;
import med.vol.api.user.AuthenticationDTO;
import med.vol.api.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO autenticationDTO) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(autenticationDTO.login(), autenticationDTO.senha());
        var authetication = authenticationManager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((User) authetication.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(tokenJWT));
    }
}
