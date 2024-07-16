package utils;
/**
 * Configuration class providing environment-specific base URLs.
 * <p>
 * This class contains methods to retrieve the base URL for different environments such as development, staging, and production.
 * </p>
 */
public class Configuration {
    /**
     * Returns the base URL for the specified environment.
     * <p>
     * This method accepts an environment string and returns the corresponding base URL.
     * Supported environments are "dev", "stagging" (note the typo in the environment name), and "production".
     * </p>
     *
     * @param environment the environment for which the base URL is needed.
     * @return the base URL corresponding to the specified environment.
     * @throws IllegalArgumentException if the specified environment is invalid.
     */
    public static String getBaseUrl(String environment) {
        switch (environment.toLowerCase()) {
            case "dev":
                return "https://demo.applitools.com/";

            case "stagging":
                return "https://stagging.applitools.com/";

            case "production":
                return "https://applitools.com/";
            default:
                throw new IllegalArgumentException("Invalid environment " + environment);
        }
    }
}
