package com.example.asrolearning.DB;

import java.util.ArrayList;
import java.util.List;

public class TopicBank {

    private static TopicDefinitions springBootDefinition(){



        final TopicDefinitions spring=new TopicDefinitions("Spring Boot is an open source Java-based framework used to create a micro Service. It is developed by Pivotal Team and is used to build stand-alone and production ready spring applications.","");


        return spring;
    }

    private static TopicDefinitions androidDefinition(){



        final TopicDefinitions android=new TopicDefinitions("Android is a mobile operating system based on a modified version of the Linux kernel and other open source software, designed primarily for touchscreen mobile devices such as smartphones and tablets.","");


        return android;
    }

    private static TopicDefinitions angularDefinition(){



        final TopicDefinitions angular=new TopicDefinitions("Angular is a TypeScript-based free and open-source web application framework led by the Angular Team at Google and by a community of individuals and corporations. Angular is a complete rewrite from the same team that built AngularJS.","");


        return angular;
    }


    private static TopicDefinitions mongoDBDefinition(){



        final TopicDefinitions mongo=new TopicDefinitions("MongoDB is a source-available cross-platform document-oriented database program. Classified as a NoSQL database program, MongoDB uses JSON-like documents with optional schemas. MongoDB is developed by MongoDB Inc. and licensed under the Server Side Public License.","");


        return mongo;
    }

    private static TopicDefinitions nodeJSDefinition(){



        final TopicDefinitions node=new TopicDefinitions("Node.js is an open-source, cross-platform, back-end JavaScript runtime environment that runs on the V8 engine and executes JavaScript code outside a web browser.","");


        return node;
    }

    public static TopicDefinitions getDefinition(String selectedTopic){
        switch (selectedTopic ){
            case "springBoot": return springBootDefinition();
            case "Android": return androidDefinition();
            case "Angular": return angularDefinition();
            case "Mongo DB": return  mongoDBDefinition();
            case "NodeJS": return nodeJSDefinition();
            default:return springBootDefinition();
        }
    }
}
