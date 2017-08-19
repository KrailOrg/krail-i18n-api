package uk.q3c.krail.i18n.test

import spock.lang.Specification
import uk.q3c.krail.i18n.UnsupportedLocaleException
import uk.q3c.util.text.MessageFormatException

import static uk.q3c.krail.i18n.persist.I18NPersistLabelKey.*

/**
 * Created by David Sowerby on 06 Aug 2017
 */
class MockTranslateTest extends Specification {

    MockTranslate translate

    def setup() {
        translate = new MockTranslate()
    }

    def "default settings"() {

        expect:
        translate.from(Source_Order) == "Source Order"


    }

    def "full response, no params"() {
        given:
        translate.returnNameOnly = false

        expect:
        translate.from(Source_Order) == "Source Order-en-GB"
    }

    def "full response, with params"() {
        given:
        translate.returnNameOnly = false

        expect:
        translate.from(Source_Order, 1, 2) == "Source Order-en-GB-1,2"
        translate.from(Source_Order, Locale.GERMANY, 1, 2) == "Source Order-de-DE-1,2"
    }

    def "fail on strictness"() {
        given:
        translate.failOnStrictness = true

        when:
        translate.from(Source_Order)

        then:
        thrown MessageFormatException
    }

    def "fail on supported locale"() {
        given:
        translate.failOnCheckLocaleIsSupported = true

        when:
        translate.from(Source_Order)

        then:
        thrown UnsupportedLocaleException
    }

    def "Both fails set, checkLocale reported"() {
        given:
        translate.failOnCheckLocaleIsSupported = true
        translate.failOnStrictness = true

        when:
        translate.from(Source_Order)

        then:
        thrown UnsupportedLocaleException
    }
}
