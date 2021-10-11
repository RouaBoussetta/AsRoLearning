package com.example.asrolearning;

import java.util.ArrayList;
import java.util.List;

public class TopicBank {

    private static TopicDefinitions springBootDefinition(){



        final TopicDefinitions spring=new TopicDefinitions("Spring Boot is an open source Java-based framework used to create a micro Service. It is developed by Pivotal Team and is used to build stand-alone and production ready spring applications.","");


        return spring;
    }



    public static TopicDefinitions getDefinition(String selectedTopic){
        switch (selectedTopic ){
            case "springBoot": return springBootDefinition();

            default:return springBootDefinition();
        }
    }
}
