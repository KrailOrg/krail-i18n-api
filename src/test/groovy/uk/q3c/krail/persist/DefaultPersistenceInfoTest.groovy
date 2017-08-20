package uk.q3c.krail.persist

import spock.lang.Specification
import uk.q3c.krail.i18n.persist.I18NPersistDescriptionKey
import uk.q3c.krail.i18n.persist.I18NPersistLabelKey

/**
 * Created by David Sowerby on 19 Aug 2017
 */
class DefaultPersistenceInfoTest extends Specification {

    class TestConfig extends DefaultPersistenceInfo {
        TestConfig() {
            name(I18NPersistLabelKey.Selected_Pattern_Targets)
            description(I18NPersistDescriptionKey.Source_Order)
            connectionUrl("connection string")
        }
    }


    DefaultPersistenceInfo info
    DefaultPersistenceInfo config

    def setup() {
        config = new TestConfig()
        info = new DefaultPersistenceInfo(config)
    }

    def "copy construct"() {
        expect:
        info.getName() == I18NPersistLabelKey.Selected_Pattern_Targets
        info.getDescription() == I18NPersistDescriptionKey.Source_Order
        info.getConnectionUrl() == "connection string"

    }
}
