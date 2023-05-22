package ru.shmvsky.browserfileexplorer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.shmvsky.browserfileexplorer.configuration.ExplorerConfiguration;
import ru.shmvsky.browserfileexplorer.exception.ExplorerRuntimeException;
import ru.shmvsky.browserfileexplorer.service.ExplorerService;

@Controller
public class ExplorerController {

    @Autowired
    private ExplorerConfiguration explorerConfiguration;

    @Autowired
    private ExplorerService explorerService;

    @GetMapping("/file-explorer")
    public ModelAndView test(@RequestParam(value = "dir", required = false) String dir) {
        ModelAndView mv = new ModelAndView("test");
        mv.addObject("files", explorerService.buildContent(dir));
        return mv;
    }

    @ExceptionHandler(ExplorerRuntimeException.class)
    public ModelAndView handleDirectoryNotFoundException(ExplorerRuntimeException ex) {
        ModelAndView mv = new ModelAndView("404");
        mv.addObject("errMsg", ex.getMessage());
        return mv;
    }

}
