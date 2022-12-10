package com.task3.springbootcli.service;

import com.task3.springbootcli.entity.Text;
import com.task3.springbootcli.repository.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TextService {

    private final TextRepository repository;

    @Autowired
    public TextService(TextRepository repository) {
        this.repository = repository;
    }

    public void addToElasticsearch(String text) {

        Text text1 = new Text(text);
        repository.save(text1);
        System.out.println("text was successfully added");
    }

    public void searchInElasticsearch(String s) {
        Text text = repository.findTextByText(s);
        System.out.println("text: " + text);
    }
}
