/*
 *
 *  * Copyright (c) 2016. David Sowerby
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 *  * the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 *  * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *  * specific language governing permissions and limitations under the License.
 *
 */

package uk.q3c.krail.i18n;

import com.google.inject.Provider;
import uk.q3c.krail.persist.PersistenceInfo;

/**
 * I18N implementation for {@link PersistenceInfo}
 * <p>
 * Created by David Sowerby on 01/07/15.
 */
public class I18NPersistenceInfo implements PersistenceInfo<I18NKey, I18NPersistenceInfo> {

    private Translate translate;
    private String connectionUrl;
    private I18NKey descriptionKey;
    private I18NKey nameKey;
    private boolean volatilePersistence;

    /**
     * Copy constructor from another {@link PersistenceInfo} instance
     *
     * @param other instance to copy from
     */
    public I18NPersistenceInfo(Provider<Translate> translateProvider, PersistenceInfo<I18NKey, ?> other) {
        this.translate = translateProvider.get();
        this.connectionUrl = other.getConnectionUrl();
        this.descriptionKey = other.getDescriptionKey();
        this.nameKey = other.getNameKey();
        this.volatilePersistence = other.isVolatilePersistence();
    }

    protected I18NPersistenceInfo() {
    }

    @Override
    public String getName() {
        return translate.from(nameKey);
    }

    @Override
    public I18NKey getDescriptionKey() {
        return descriptionKey;
    }

    @Override
    public I18NKey getNameKey() {
        return nameKey;
    }

    @Override
    public String getDescription() {
        return translate.from(descriptionKey);
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
    public I18NPersistenceInfo nameKey(final I18NKey nameKey) {
        this.nameKey = nameKey;
        return this;
    }

    @Override
    public I18NPersistenceInfo descriptionKey(final I18NKey descriptionKey) {
        this.descriptionKey = descriptionKey;
        return this;
    }

    @Override
    public I18NPersistenceInfo connectionUrl(final String connectionUrl) {
        this.connectionUrl = connectionUrl;
        return this;
    }

    @Override
    public I18NPersistenceInfo volatilePersistence(final boolean volatilePersistence) {
        this.volatilePersistence = volatilePersistence;
        return this;
    }
}