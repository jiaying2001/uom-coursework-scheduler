package com.jiaying.resource;

import org.json.JSONArray;

import com.jiaying.loader.ResourceLoader;
import com.jiaying.parser.Parser;

abstract class ResourceFromWeb extends AbstractResource {
	
	ResourceFromWeb(Parser parser, ResourceLoader loader) {
		super(parser, loader);
	}

	@Override
	void assemble(String scriptName) {
		String courseUnitsJsonStr = loader.load(scriptName);
		JSONArray courseunits = new JSONArray(courseUnitsJsonStr);
		this.courseWorks = parser.parse(courseunits);
	}

}
