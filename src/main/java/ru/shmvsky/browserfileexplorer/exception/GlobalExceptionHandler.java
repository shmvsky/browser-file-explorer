package ru.shmvsky.browserfileexplorer.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import ru.shmvsky.browserfileexplorer.configuration.ExplorerConfiguration;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final ExplorerConfiguration explorerConfiguration;

    public GlobalExceptionHandler(ExplorerConfiguration explorerConfiguration) {
        this.explorerConfiguration = explorerConfiguration;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ModelAndView handleConstraintViolationException(ConstraintViolationException ex) {
        ModelAndView mv = new ModelAndView("404");
        mv.addObject("baseDirPath", explorerConfiguration.getBaseDirPath());
        mv.addObject("errMsg", ex.getMessage());
        return mv;
    }

    @ExceptionHandler(ExplorerRuntimeException.class)
    public ModelAndView handleExplorerRuntimeException(ExplorerRuntimeException ex) {
        ModelAndView mv = new ModelAndView("404");
        mv.addObject("baseDirPath", explorerConfiguration.getBaseDirPath());
        mv.addObject("errMsg", ex.getMessage());
        return mv;
    }

}
