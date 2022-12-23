package com.jiaying.resource;

import org.json.JSONArray;
import org.springframework.stereotype.Component;

import com.jiaying.loader.ResourceLoader;
import com.jiaying.parser.Parser;

@Component
abstract class ResourceFromWeb extends AbstractResource {
	
	ResourceFromWeb(Parser parser, ResourceLoader loader) {
		super(parser, loader);
	}

	@Override
	public void assemble(String scriptName) {
		String courseUnitsJsonStr = loader.load(scriptName);
		JSONArray courseunits = new JSONArray(courseUnitsJsonStr);
		this.courseWorks = parser.parse(courseunits);
	}

}
