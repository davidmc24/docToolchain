package doctoolchain.confluence

import org.jsoup.Jsoup
import spock.lang.Specification

class PublishToConfluenceTaskSpec extends Specification {
    def "rewriteMarks applies default styling"() {
        given: "some HTML content with mark elements"
        def htmlContent = "<body><p>This is some <mark>important text</mark> and some <mark><em>more</em> important text</mark>.</p></body>"
        def body = Jsoup.parse(htmlContent)

        when: "rewriteMarks is called"
        PublishToConfluenceTask.rewriteMarks(body)

        then: "mark elements are re-written to spans with inline styles"
        body.toString() == "<html>\n" +
                " <head></head>\n" +
                " <body>\n" +
                "  <p>This is some <span style=\"background:#ff0;color:#000\">important text</span> and some <span style=\"background:#ff0;color:#000\"><em>more</em> important text</span>.</p>\n" +
                " </body>\n" +
                "</html>"
    }
}
