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
package uk.q3c.krail.i18n

import java.io.Serializable
import java.util.*

/**
 * Provides a reference to the currently selected Locale.  It is expected that implementations will generally be scoped appropriately
 * to reflect that the selection of locale is a choice usually available to an individual user.
 *
 *
 * Changes to Locale should be published to an event bus with a compatible scope.
 *
 *
 *
 * @author David Sowerby 3 Mar 2013
 */

interface CurrentLocale : Serializable {

    var locale: Locale

    /**
     * Sets up the locale from the environment (typically browser locale and user option settings)
     */
    fun readFromEnvironment()

    fun setLocale(locale: Locale, fireListeners: Boolean)


}
