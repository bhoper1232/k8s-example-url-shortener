package com.bhoper.controller;

import com.bhoper.client.url.UrlClient;
import com.bhoper.client.url.UrlModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UrlController {

    private final UrlClient urlClient;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("urlModel", new UrlModel());
        return "create-short-url";
    }

    @GetMapping("/short-url")
    public String showShortUrl(@ModelAttribute("urlModel") UrlModel urlModel, Model model) {
        model.addAttribute("url", urlModel);
        return "show-short-url";
    }

    @PostMapping("/create")
    public String createShortUrl(@ModelAttribute("urlModel") UrlModel urlRequest, RedirectAttributes redirectAttributes) {
        Map<String, String> map = new HashMap<>();
        map.put("originalUrl", urlRequest.getOriginalUrl());
        String shortenUrl = this.urlClient.shortenUrl(map);
        urlRequest.setShortUrl(shortenUrl);

        redirectAttributes.addFlashAttribute("urlModel", urlRequest);

        return "redirect:/short-url";
    }
}
