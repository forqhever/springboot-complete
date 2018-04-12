module springbootcomplete {
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires org.apache.commons.lang3;
    requires spring.web;
    requires tomcat.embed.core;
    requires slf4j.api;
    requires spring.context;
    requires spring.webmvc;
    requires spring.beans;
    requires java.sql;

    exports com.forqhever.springbootcomplete to
            spring.beans,
            spring.core,
            spring.context;
    opens com.forqhever.springbootcomplete to
            spring.core,
            spring.beans,
            spring.context;

    exports com.forqhever.springbootcomplete.filter to
            spring.beans;

    exports com.forqhever.springbootcomplete.interceptor to
            spring.beans,
            spring.core,
            spring.context;
    opens com.forqhever.springbootcomplete.interceptor to
            spring.core,
            spring.beans,
            spring.context;

    exports com.forqhever.springbootcomplete.kafka.web.controller to
            spring.beans,
            spring.core,
            spring.context;
    opens com.forqhever.springbootcomplete.kafka.web.controller to
            spring.core,
            spring.beans,
            spring.context,
            spring.web;

    opens com.forqhever.springbootcomplete.entity to
            org.apache.commons.lang3;
}