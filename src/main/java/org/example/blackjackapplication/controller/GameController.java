package org.example.blackjackapplication.controller;

import org.example.blackjackapplication.model.BlackJackApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GameController {

    private BlackJackApplication game = new BlackJackApplication();

    @GetMapping("/")
    public String showGame(Model model) {
        model.addAttribute("game", game);
        return "game";
    }

    @PostMapping("/hit")
    public String hit() {
        game.hit();
        return "redirect:/";
    }

    @PostMapping("/stand")
    public String stand() {
        game.stand();
        return "redirect:/";
    }

    @PostMapping("/reset")
    public String reset() {
        game = new BlackJackApplication();
        return "redirect:/";
    }
}