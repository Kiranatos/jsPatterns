package net.kiranatos.c3factorymethod.e3log;

public class FactoryMethodLogger {
    public static void main(String[] args) {
        LoggingProviders providerType = GetTypeOfLoggingProviderFromConfigFile();
        ILogger logger = LoggerProviderFactory.GetLoggingProvider(providerType);
        logger.LogMessage("Hello Factory Method Design Pattern.");
    }
    private static LoggingProviders GetTypeOfLoggingProviderFromConfigFile() {
        return LoggingProviders.Enterprise;
    }
}

enum LoggingProviders { Enterprise, Log4Net }

// Creator & ConcreteCreator
class LoggerProviderFactory {
    public static ILogger GetLoggingProvider(LoggingProviders logProviders) {
        switch (logProviders) {
            case Enterprise: return new EnterpriseLogger();
            case Log4Net:    return new Log4NetLogger();
            default:         return new EnterpriseLogger();
        }
    }
}

// Product
interface ILogger {
    void LogMessage(String message);
    void LogError(String message);
    void LogVerboseInformation(String message);
}

// ConcreteProduct
class EnterpriseLogger implements ILogger {
    public void LogMessage(String message) {                System.out.printf("Enterprise: %s\n", message); }    
    public void LogError(String message) {                  throw new UnsupportedOperationException(); }    
    public void LogVerboseInformation(String message) {     throw new UnsupportedOperationException();  }
}

// ConcreteProduct
class Log4NetLogger implements ILogger { // Вивід: [Log4Net: Hello Factory Method Design Pattern]
    public void LogMessage(String message) {                System.out.printf("Log4Net: %s\n", message);     }    
    public void LogError(String message) {                  throw new UnsupportedOperationException();    }    
    public void LogVerboseInformation(String message) {     throw new UnsupportedOperationException();    }
}