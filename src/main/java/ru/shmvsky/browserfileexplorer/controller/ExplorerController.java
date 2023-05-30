package ru.shmvsky.browserfileexplorer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.shmvsky.browserfileexplorer.configuration.ExplorerConfiguration;
import ru.shmvsky.browserfileexplorer.exception.ExplorerRuntimeException;
import ru.shmvsky.browserfileexplorer.service.ExplorerService;

@Controller
public class ExplorerController {
    private ExplorerConfiguration explorerConfiguration;

    private ExplorerService explorerService;

    public ExplorerController(ExplorerConfiguration explorerConfiguration, ExplorerService explorerService) {
        this.explorerConfiguration = explorerConfiguration;
        this.explorerService = explorerService;
    }

    @GetMapping("/file-explorer")
    public ModelAndView test(@RequestParam(value = "dir") String dirPath) {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("meta", explorerService.buildMeta());
        mv.addObject("content", explorerService.buildContent(dirPath));
        return mv;
    }

    @ExceptionHandler(ExplorerRuntimeException.class)
    public ModelAndView handleExplorerRuntimeException(ExplorerRuntimeException ex) {
        ModelAndView mv = new ModelAndView("404");
        mv.addObject("baseDirPath", explorerConfiguration.getBaseDirPath().replace("\\", "/"));
        mv.addObject("errMsg", ex.getMessage());
        return mv;
    }

}
