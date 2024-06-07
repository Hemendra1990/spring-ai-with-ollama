package com.hemendra.langchainembeddings.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/story-teller")
public class StorytellerController {

    /*private String systemPrompt = """
            You are a helpful assistant, conversing with a user about the subjects contained in a set of documents.
            Use the information from the DOCUMENTS section to provide accurate answers. If unsure or if the answer
            isn't found in the DOCUMENTS section, simply state that you don't know the answer.

            QUESTION:
            {input}

            DOCUMENTS:
            {documents}
            """;*/
    private String systemPrompt = """
            You are a helpful assistant, conversing with a user about the subjects contained in a set of documents.
            Use the information from the DOCUMENTS section to provide accurate answers. If unsure or if the answer
            isn't found in the DOCUMENTS section, then you analyze yourself and provide the answer.

            QUESTION:
            {input}

            DOCUMENTS:
            {documents}
            """;

    @Autowired
    VectorStore vectorStore;

    private final ChatClient chatClient;

    public StorytellerController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping
    public String chat(@RequestParam(value = "query", defaultValue = "What is the story about?") String query) {
        List<Document> documents = vectorStore.similaritySearch(query);
        List<String> contents = documents.stream().map(Document::getContent).toList();

        //System Prompts
        PromptTemplate promptTemplate = new PromptTemplate(systemPrompt);

        Map<String, Object> promptParameters = Map.of(
                "input", query,
                "documents", String.join("\n", contents)
        );
        Prompt prompt = promptTemplate.create(promptParameters);
        String result = chatClient.prompt(prompt).call().chatResponse().getResult().getOutput().toString();
        return result;
    }

    @GetMapping("/streaming")
    public Flux<String> streamingChat(@RequestParam(value = "query", defaultValue = "What is the story about?") String query) {
        List<Document> documents = vectorStore.similaritySearch(query);
        List<String> contents = documents.stream().map(Document::getContent).toList();
        //System Prompts
        PromptTemplate promptTemplate = new PromptTemplate(systemPrompt);

        Map<String, Object> promptParameters = Map.of(
                "input", query,
                "documents", String.join("\n", contents)
        );
        Prompt prompt = promptTemplate.create(promptParameters);
        return chatClient.prompt(prompt).stream().content();
    }
}
