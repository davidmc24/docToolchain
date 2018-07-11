package doctoolchain.confluence

import org.gradle.api.Plugin
import org.gradle.api.Project

class PublishToConfluencePlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.tasks.create('publishToConfluence', PublishToConfluenceTask) {
            description = 'publishes the HTML rendered output to confluence'
            group = 'docToolchain'
        }
    }
}
