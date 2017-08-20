package uk.q3c.krail.persist;

/**
 * Created by David Sowerby on 20 Aug 2017
 */

import uk.q3c.krail.i18n.I18NKey;

/**
 * Provides a common set of persistence information across all type of persistence.  Usually implemented by a persistence-related Guice module or a persistence
 * configuration object
 * <p>
 * Created by David Sowerby on 01/07/15.
 */
public interface PersistenceInfo<C> {


    C name(I18NKey nameKey);

    C description(I18NKey nameKey);

    C connectionUrl(String url);

    /**
     * Set to true if the persistence is volatile (that is, in memory)
     *
     * @param isVolatile true if persistence is volatile
     * @return this for fluency
     */
    C volatilePersistence(boolean isVolatile);

    I18NKey getDescription();

    I18NKey getName();

    String getConnectionUrl();

    /**
     * Returns true if the persistence is volatile (that is, in memory)
     */
    boolean isVolatilePersistence();
}