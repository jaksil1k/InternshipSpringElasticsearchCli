package com.task3.springbootcli;

import com.task3.springbootcli.service.TextService;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringbootCliApplication implements CommandLineRunner {

	@Autowired
	private TextService elasticSearchService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello from main");
		Options options = new Options();
		options.addOption("e", true, "commands add or search in elasticsearch")
				.addOption("s", false, "some text");

		CommandLineParser parser = new DefaultParser();
		CommandLine line = parser.parse(options, args);

		if (line.hasOption("e") && line.hasOption("s")){
			if (!line.getOptionValue("e").equals("add") && !line.getOptionValue("e").equals("search")){
				System.out.println("unknown command");
			} else {
				if (line.getOptionValue("e").equals("add")){
					elasticSearchService.addToElasticsearch(line.getOptionValue("s"));
				} else {
					elasticSearchService.searchInElasticsearch(line.getOptionValue("s"));
				}
			}
		} else {
			System.out.println("should be in this pattern: -e add/search -s <some text>");
		}
	}

	public static void main(String[] args) throws Exception {

		SpringApplication.run(SpringbootCliApplication.class, args);
	}

}
