package com.task3.springbootcli.repository;

import com.task3.springbootcli.entity.Text;
import org.springframework.data.repository.CrudRepository;



public interface TextRepository extends CrudRepository<Text, String> {
    public Text findTextByText(String text);

}
