import groovy.json.JsonSlurper
import groovy.text.markup.MarkupTemplateEngine
import groovy.text.markup.TemplateConfiguration
import orh.JSONTemplate

/**
 * Created by Avvero on 28.07.2017.
 */
def binding = new JsonSlurper().parseText(new File('data.json').text)
def config = new TemplateConfiguration()
config.baseTemplateClass = JSONTemplate.class

def engine = new MarkupTemplateEngine(config)
def template = engine.createTemplate(new File('profile.template'))

def t = new Date().time
1.times {
    Thread thread = new Thread(new Runnable() {
        @Override
        void run() {
            println template.make(binding)
        }
    })
    thread.start()
    thread.join()
}
t = new Date().time - t
println (t / 1000)
