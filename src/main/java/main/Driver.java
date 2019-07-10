package main;

import service.TagService;

public class Driver {
static TagService ts;
	public static void main(String[] args) {
		System.out.println(ts.selectAllTags());

	}

}
