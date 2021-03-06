package com.github.edgar615.spring.operatelog;

import org.slf4j.Logger;

/**
 * 从别的地方借鉴的. https://github.com/t1/logging-interceptor.git
 */
public enum LogLevel {
  TRACE {
    @Override
    public boolean isEnabled(Logger logger) {
      return logger.isTraceEnabled();
    }

    @Override
    public void log(Logger logger, String message, Object... args) {
      logger.trace(message, args);
    }

    @Override
    public void log(Logger logger, String message, Throwable throwable) {
      logger.trace(message, throwable);
    }
  },
  DEBUG {
    @Override
    public boolean isEnabled(Logger logger) {
      return logger.isDebugEnabled();
    }

    @Override
    public void log(Logger logger, String message, Object... args) {
      logger.debug(message, args);
    }

    @Override
    public void log(Logger logger, String message, Throwable throwable) {
      logger.debug(message, throwable);
    }
  },
  INFO {
    @Override
    public boolean isEnabled(Logger logger) {
      return logger.isInfoEnabled();
    }

    @Override
    public void log(Logger logger, String message, Object... args) {
      logger.info(message, args);
    }

    @Override
    public void log(Logger logger, String message, Throwable throwable) {
      logger.info(message, throwable);
    }
  },
  WARN {
    @Override
    public boolean isEnabled(Logger logger) {
      return logger.isWarnEnabled();
    }

    @Override
    public void log(Logger logger, String message, Object... args) {
      logger.warn(message, args);
    }

    @Override
    public void log(Logger logger, String message, Throwable throwable) {
      logger.warn(message, throwable);
    }
  },
  ERROR {
    @Override
    public boolean isEnabled(Logger logger) {
      return logger.isErrorEnabled();
    }

    @Override
    public void log(Logger logger, String message, Object... args) {
      logger.error(message, args);
    }

    @Override
    public void log(Logger logger, String message, Throwable throwable) {
      logger.error(message, throwable);
    }
  },
  OFF {
    @Override
    public boolean isEnabled(Logger logger) {
      return false;
    }

    @Override
    public void log(Logger logger, String message, Object... args) {
    }

    @Override
    public void log(Logger logger, String message, Throwable throwable) {
    }
  };

  public abstract boolean isEnabled(Logger logger);

  public abstract void log(Logger logger, String message, Object... args);

  public abstract void log(Logger logger, String message, Throwable throwable);
}
