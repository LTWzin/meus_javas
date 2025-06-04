package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import entities.Comment;
import entities.Post;

public class Main {

	public static void main(String[] args) {
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");	
		
		Comment c1 = new Comment("Have a nice trip.");
		Comment c2 = new Comment("Wow, that's awesome!");
		Post p1 = new Post(LocalDateTime.parse("21/06/2018 13:05:44", fmt1), 
				"Traveling to New Zealand", 
				"I'm gonna visit this wonderfull country", 
				12);
		p1.addComment(c1);
		p1.addComment(c2);
		
		Comment c3 = new Comment("Good night.");
		Comment c4  = new Comment("May the force be with you!");
		Post p2 = new Post(LocalDateTime.parse("28/07/2018 23:14:19", fmt1),
				"Good night guys",
				"See you guys tomorrow",
				5);
		p2.addComment(c3);
		p2.addComment(c4);
		
		System.out.println(p1);
		System.out.println();
		System.out.println(p2);
	}
}
