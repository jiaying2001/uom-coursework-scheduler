package com.jiaying.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.jiaying.loader.ResourceLoader;
import com.jiaying.parser.Parser;

@Component
public class UomSpotResource extends ResourceFromWeb{
	
	@Autowired
	UomSpotResource(@Qualifier("jsonParser")Parser parser, @Qualifier("pythonLoader")ResourceLoader loader) {
		super(parser, loader);
	}
}
