package com.ticket.captain.account;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.net.URISyntaxException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Controller
@RequiredArgsConstructor
@RequestMapping(value="/sign-up", produces = MediaTypes.HAL_JSON_VALUE)
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public String signUpForm(Model model){
        model.addAttribute(new SignUpForm());
        return "account/sign-up";
    }

    @PostMapping
    public ResponseEntity createAccount(@RequestBody SignUpForm signUpForm, Errors errors) throws URISyntaxException {
        if(errors.hasErrors()){
            return ResponseEntity.unprocessableEntity().body(signUpForm);
        }
        Account account = accountService.createAccount(signUpForm);
        URI createdUri = linkTo(AccountController.class).slash(account.getId()).toUri();
        return ResponseEntity.created(createdUri).body(signUpForm);
    }

}
