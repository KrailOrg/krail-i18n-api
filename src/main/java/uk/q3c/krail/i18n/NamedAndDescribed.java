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

import java.io.Serializable;

/**
 * A common interface for items which need translated name and description
 * <p>
 * Created by David Sowerby on 08 Feb 2016
 */
public interface NamedAndDescribed extends Serializable {

    I18NKey getNameKey();

    void setNameKey(I18NKey nameKey);

    I18NKey getDescriptionKey();

    void setDescriptionKey(I18NKey descriptionKey);

    /**
     * Returns translated name key
     *
     * @return translated name key
     */
    String getName();

    /**
     * Returns translated description key
     *
     * @return translated description key
     */
    String getDescription();
}
