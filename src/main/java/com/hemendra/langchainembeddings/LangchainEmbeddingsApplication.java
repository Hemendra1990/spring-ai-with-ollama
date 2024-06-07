package com.hemendra.langchainembeddings;

import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class LangchainEmbeddingsApplication {

    @Bean
    VectorStore vectorStore(EmbeddingModel embeddingModel) {
        return new SimpleVectorStore(embeddingModel);
    }

    public static void main(String[] args) {
        SpringApplication.run(LangchainEmbeddingsApplication.class, args);
    }

    @Bean
    TokenTextSplitter tokenTextSplitter() {
        return new TokenTextSplitter();
    }

    private boolean ingest = true;

    @Bean
    ApplicationRunner runner(TokenTextSplitter tokenTextSplitter, VectorStore vectorStore) {
        return args -> {
            if (this.ingest) {
                List<Document> documents = List.of(
                        new Document("Spring AI rocks!! Spring AI rocks!! Spring AI rocks!! Spring AI rocks!! Spring AI rocks!!", Map.of("meta1", "meta1")),
                        new Document("The World is Big and Salvation Lurks Around the Corner"),
                        new Document("""
                                In ancient time there was a king in Baranasi named Brahmadatta. At that time there was a village in Kasi Kingdom named Dharmapal. A learned Brahman lived in this village. He practiced ten good creeds (Dasa Kusala Dhamma). He was called Dharmapal by the people. His family members and the servants were charitable. They observed precepts (Sila) and fasting vow.
                                                                
                                Badhisattva was born in this race as a son of the learned Brahman. He was assumed Dharmapal Kumar. When he came to age, his father sent him to a teacher in Taxila for education. The teacher had five hundred pupils. Gradually Bodhisattva became the best of all among the pupils.
                                One day the elder son of the teacher died. The teacher, kinsmen, friends and the pupils were crying. Only Dharmapal Kumar, the Bodhisattva did not cry. He laughed.
                                                                
                                The teacher wanted to know the reason of his laughing. Then Dharmapal said, nobody died in tender age in his race. To know the genuineness of his words, one day the teacher went to Dhamapal’s house with a bone of dead-goat. The teacher said to his father that Dharmapal died. But Dharmapal’s did not trust. The teacher showed the bone of goat and said, this is the bone of Dharmapal. By no means, the father of Dharmapal trusted it. The teacher acknowledged the truth.                                                                              
                                Now the teacher said with joy, ‘Oh Brahmin! Your son is alive. He is my chief disciple. I have come here to give him charge to teach the other pupils. Your son told me that-nobody dies in your race in the young-age. I want to know from you the causes of this. Then the Brahman hearing his words described the causes by which virtues nobody in his race does not die untimely. He said that they were never addicted to bad deed. We give up the bad and always worship the good. So, in our race, nobody dies in young age.
                                Our mind is pleased before giving. We give with pleasure and respect, we do not after giving repents. So no young man dies. Sraman, Brahman, wayfarer, mendicant, poor, beggar, whoever comes to our house we satisfy them with food and drink. We give them according to our capacity.
                                ‘The husbands are honest and the wives are devoted to their husbands in our race. We follow Brahmacharya in equal virtues. In this race, who is born in the womb of an honest wife, is to be meritorious, pious, wise, well versed in all scriptures and devotions. All members follow the path of virtue hoping to attain heaven after death. The servants also follow the path of virtue.’
                                                                
                                Then the Brahman told, ‘He who follows the path of virtue, the virtue (Dharma) protects him. As an umbrella protects man from rain and sun, the Dharma protects also the pious. Never any harm is done to pious. So I say, which bone you have brought belonged to other. It is impossible that my son will die in young-age. Hearing this words, the teacher prayed with joy forgiveness of the Brahman. He said to the Brahman, ‘I brought a goat-bone to you to examine. Your son is well. Now, kindly say to me which Dharma (virtue) you have observed.’
                                                                
                                We observe Ariyadharma, Four Noble Truths; Eightfold Paths, Brahmavihara, fasting and five precepts. The teacher returned Taxila after some days. Then he taught Dharmapal Kumar all kinds of education and then sent him to his house with many attendants.
                                """, Map.of("story", "kids", "panchatantra", "story")),
                        new Document("""
                                These are below information about Chandan Kumar Dash or Dash Babu
                                                                
                                •	Good knowledge of LWC, APEX.
                                •	Experience in Batch and Schedule Apex.
                                •	Ability to write triggers for business requirements.
                                •	Ability to write SOQL, SOSL queries across multiple objects within the SFDC database.
                                •	Experience working with Salesforce.com sandbox and production environments with Change Sets.
                                •	Good Experience in SFDC Administrative tasks like creating profiles, users, Roles, Objects, permission sets, Email notifications and Templates, Outbound Messaging, Tasks, Lead Assignment rule, Events and Actions, Creating Flows, Process Builders, Approval Process.
                                •	Experience in Dynamic forms.
                                •	Very good Experience in Data Security using profile, role, permission set and account team.
                                •	Experience on Salesforce Lightening for Customizing Reports and Dashboards for business use.
                                •	Experience in Community Cloud and Sales Cloud.
                                •	Experience in digital document tool Conga Composer and Conga Batch.
                                """, Map.of("resume", "Chandan Kumar Dash", "salesforce", "resume", "good", "knowledge in Salesforce", "indsutry", "CRM")),
                        new Document("""
                                Aswini Kumar Biswal
                                Java Developer
                                Email: aswini.biswal@bipros.com
                                Mobile: +91  8144396577
                                                                
                                Experience Summary
                                Overall 2+ years of IT experience in designing, developing and architecting applications. Rich implementation experience with industry domains like Health and Human Services, Workflow Automation and Business Intelligence.
                                Engaged in thorough requirement analysis, including comprehension of client 	needs and active participation in client meetings\s
                                Roles and Responsibility: Developing, Bug fixing, writing test cases, Functional testing.
                                                                
                                TOP SKILLS
                                Core Java, Java 8, JAVA/J2EE
                                Angular, React,\s
                                PostgreSQL, Oracle, MySQL
                                Tomcat
                                Maven
                                Spring, Spring boot, Hibernate
                                DBeaver, Postman, Swagger, JMeter 	
                                                                
                                INDUSTRY & DOMAIN KNOWLEDGE
                                Healthcare
                                HRMS
                                                                
                                RELEVANT EXPERIENCE
                                BIP CRM (In-House):
                                Role: Developer
                                Technologies: Java(Spring Boot), React, Spring Cloud, KeyCloak
                                Project Description:
                                It is a customer relationship management application just like Salesforce, We have implemented all the features of a CRM Sales system into own application. This is in development stage.
                                Responsibilities:
                                                                
                                Designer (Client Project):
                                Role: Developer
                                Technologies: Java, Angular, React
                                Project Description:
                                A low code designer enabling design of web pages, data capture forms, charts, reports and dashboards through a simple drag-drop UI.
                                                                
                                                                
                                                                
                                """, Map.of("name", "Ashwini", "java", "very good", "man", "well mannerd")),
                        new Document("""
                                                Arupananda Pal. He is also know as Pal Babu. He is from Balasore Odisha. This document gives a brief introduction about him. This is actually his resume.
                                Professional Summary:                                                                        Professional Highlights:
                                •   I possess more than 5 years of professional experience in the IT field,              •     Implemented Config Server and Security in Unity-Sphere application.
                                    specializing in the analysis, design, and development of web-based and client-       •     Designed and implemented Timesheet and Appraisal module in Unity-Sphere.
                                    server applications. My expertise encompasses technologies such as Java 8, J2EE,     •     Introduced Spring AOP to WorkforceQA to handle field level authorization for rest
                                    Spring Boot, Hibernate, Microservices and RESTful web services.                            apis.
                                                                                                                         •     Actively aided WorkforceQA's development, task distribution, and ongoing
                                •   Working experience on Collection, OOPs, Exception Handling, Multi-Threading,
                                                                                                                               maintenance with dedicated contributions.
                                    Stream API. My skill set includes hands-on experience with fundamental
                                                                                                                         •     Created and crafted the Nomenclature module in DHI, integrating
                                    programming concepts, including Collections, Object-Oriented Programming
                                                                                                                               internationalization features for improved user interactions in academic settings
                                    (OOPs), Exception Handling, Multi-Threading, and Stream API usage.
                                                                                                                               like degree colleges, PU colleges, and schools.
                                •   I have a strong track record of coding using Spring Boot, Spring IOC, Spring JDBC,   •     Led a team of four members in the design and development of the Hostel and
                                    Spring Data JPA, Spring REST, and Spring Transaction, showcasing my proficiency            Grievance Module within the framework of DHI.
                                    in Spring framework technologies.                                                        My Responsibilities Include:
                                • In addition to my technical prowess, I possess knowledge in Microservices              • In my capacity as a senior developer, I collaborated closely with the Enterprise
                                  Architecture, allowing me to contribute effectively to modern software                   Architect to comprehend design details and construct various modules, while also
                                  development paradigms.                                                                   overseeing project implementation.
                                Technical Expertise:
                                                                                                                         • I actively engaged with customers, gathering requirements and reviewing
                                 Domain: Healthcare, HRMS, EdTech                                                         proposed solutions, and conducted end-to-end assessments of application
                                 Language: Core Java, Java 8, JAVA/J2EE                                                   component interactions and module routing.
                                   Frameworks: Spring Framework, Spring Boot, Microservices, Spring Data JPA            • Engaged in thorough requirement analysis, including comprehension of client
                                   Databases: MongoDB, Postgres                                                           needs and active participation in client meetings. Also responsible for task
                                   Version Control: GIT, SVN                                                              allocation and the design of workflow processes.
                                   Logging: Log4j                                                                           Latest Three projects:
                                   Web Servers: Tomcat ,Wildfly                                                         1.     Unity Sphere
                                   Development and Testing Tools: Robo 3T, DBeaver, Postman, Swagger, Jira              2.     WorkforceQA
                                                                                                                         3.     DHI
                                
                                """, Map.of("name", "Arup", "altername", "Arupanada", "anothername", "Radhe", "from", "balasore")),
                        new Document("""
                                                                                       TOP SKILLS                               RELEVANT
                                                                                                                                EXPERIENCE
                                                                
                                                                                     Microservice, Web Service
                                                                                                                       UnitySphere (In-House):
                                                                                     Spring, Spring boot, Hibernate
                                                                                                                       Role: Senior Software Engineer
                                                                                     Angular, React, Thymleaf
                                                                                                                       Project Description:
                                                                                     PostgreSQL, MySQL
                                                                                                                       It is a kind of ERP product having some modules like, CRM, Timesheet, Leave, Requisition,
                                       Saumyaranjan Giri    (The Banguru boy)                          Maven, Gradle                    EmployeeManagement and so on.
                                               Java Developer                        Git, GitLab                      Responsibilities:
                                    Email: saumyaranjan.giri@bipros.com              Docx4j                           • Database design, process define, Developing, coding.
                                    Mobile: +91 9861687226                           Agile Development
                                                                
                                Experience Summary                                                                     SMARBL (Client Project):
                                                                                                                       Role: Senior Software Engineer
                                Overall 5 years of IT experience in
                                                                                                                       Project Description:
                                designing, developing and architecting                INDUSTRY & DOMAIN
                                                                                                                       Led the development of a dynamic reporting system for a banking project, ensuring efficient generation of
                                applications. Implementation experience               KNOWLEDGE
                                                                                                                       diverse reports tailored to user specifications.
                                with industry domains like Health and
                                                                               •   Banking                             Responsibilities:
                                Human Services, Workflow Automation and
                                Business Intelligence.                         •   HRMS                                • Developing, Designing, Debugging
                                                                               •   Petroleum Industry
                                    Very     Good      knowledge       on                                             IOCL (Client Project):
                                     Spring/Spring boot.
                                                                                                                       Role: Developer and Maintainer
                                    Well versed in creating detailed                                                  Technologies: Java, Angular
                                     business analysis, outlining problems,                                            Project Description:
                                     opportunities, and solutions for a                                                The project is involved in periodic transfer of equipment data from multiple Control Room to Central
                                     business.                                                                         server, which requires to read data from various data sources like MS-Access, MySQL, Postgres, SQL Lite,
                                                                                                                       MariaDB, MSSQL, CSV & Excel, gather and summarize them and then pushing them to the central server.
                                    Very Good Knowledge in OOPs concepts
                                     and implementation with Design Patterns                                           Responsibilities:
                                                                                                                       Developing, Designing, Debugging, writing test cases, Functional testing, coding.
                                    Very Good knowledge on Data
                                     Structure and Algorithms
                                                                
                                    Well versed with System Design
                                
                                """, Map.of("name", "Saumya", "altername", "Saumya The Bangara boy", "anothername", "Banguru from Balasore", "from", "Sikidia")),
                        new Document("You walk forward facing the past and you turn back toward the future.", Map.of("meta2", "meta2")));

                var tokens = tokenTextSplitter.apply(documents);
                //vectorStore.add(tokens);
                vectorStore.accept(tokens);
            }
        };
    }

}
