package ru.shmvsky.browserfileexplorer.exception;

public class ExplorerRuntimeException extends RuntimeException {

    public ExplorerRuntimeException() {
        super();
    }

    public ExplorerRuntimeException(String message) {
        super(message);
    }

    public ExplorerRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExplorerRuntimeException(Throwable cause) {
        super(cause);
    }

    protected ExplorerRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
