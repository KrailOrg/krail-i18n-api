package uk.q3c.krail.persist;

import uk.q3c.krail.i18n.I18NKey;

/**
 * Default implementation for {@link PersistenceInfo}
 * <p>
 * Created by David Sowerby on 01/07/15.
 */
public class DefaultPersistenceInfo implements PersistenceInfo<DefaultPersistenceInfo> {

    private String connectionUrl;
    private I18NKey description;
    private I18NKey name;
    private boolean volatilePersistence;

    public DefaultPersistenceInfo() {
    }

    /**
     * Copy constructor from another {@link PersistenceInfo} instance
     *
     * @param other
     */
    public DefaultPersistenceInfo(PersistenceInfo<?> other) {
        this.connectionUrl = other.getConnectionUrl();
        this.description = other.getDescription();
        this.name = other.getName();
        this.volatilePersistence = other.isVolatilePersistence();
    }

    @Override
    public I18NKey getName() {
        return name;
    }

    @Override
    public I18NKey getDescription() {
        return description;
    }

    @Override
    public String getConnectionUrl() {
        return connectionUrl;
    }

    @Override
    public boolean isVolatilePersistence() {
        return volatilePersistence;
    }

    @Override
    public DefaultPersistenceInfo name(final I18NKey name) {
        this.name = name;
        return this;
    }

    @Override
    public DefaultPersistenceInfo description(final I18NKey description) {
        this.description = description;
        return this;
    }

    @Override
    public DefaultPersistenceInfo connectionUrl(final String connectionUrl) {
        this.connectionUrl = connectionUrl;
        return this;
    }

    @Override
    public DefaultPersistenceInfo volatilePersistence(final boolean volatilePersistence) {
        this.volatilePersistence = volatilePersistence;
        return this;
    }
}
