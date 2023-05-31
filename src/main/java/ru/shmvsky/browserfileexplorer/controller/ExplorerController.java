package ru.shmvsky.browserfileexplorer.controller;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.shmvsky.browserfileexplorer.service.ExplorerService;
import ru.shmvsky.browserfileexplorer.validation.RealPath;

@Controller
@Validated
public class ExplorerController {

    private final ExplorerService explorerService;

    public ExplorerController(ExplorerService explorerService) {
        this.explorerService = explorerService;
    }

    @GetMapping("/file-explorer")
    public ModelAndView getContent(@RealPath @NotBlank @RequestParam(value = "dir") String dirPath) {
        ModelAndView mv = new ModelAndView("index");

        mv.addObject("meta", explorerService.buildMeta());
        mv.addObject("content", explorerService.buildContent(dirPath));

        return mv;
    }

}
