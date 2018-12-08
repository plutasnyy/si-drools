package com.drools.si;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.drools.compiler.compiler.DroolsParserException;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import javax.swing.*;

public class MainClass {
    public static void main(String[] args) throws DroolsParserException,
            IOException {
        MainClass mainClass = new MainClass();
        mainClass.executeHelloWorldRules();
    }

    public void executeHelloWorldRules() throws IOException, DroolsParserException {
        KieServices ks = KieServices.Factory.get();
        BasicConfigurator.configure();
        Logger.getLogger(MainClass.class).setLevel(Level.OFF);

        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession session = kContainer.newKieSession("ksession-rules");

        QuestionWithAnswer startQuestion = new QuestionWithAnswer();
        session.insert(startQuestion);
        
        session.fireAllRules();
    }
}