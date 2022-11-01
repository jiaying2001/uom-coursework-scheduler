package com.jiaying.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.jiaying.loader.ResourceLoader;
import com.jiaying.parser.Parser;

public class UomSpotResource extends ResourceFromWeb{
	
	@Autowired
	UomSpotResource(@Qualifier("jsonParser")Parser parser, @Qualifier("pythonLoader")ResourceLoader loader) {
		super(parser, loader);
	}
}
