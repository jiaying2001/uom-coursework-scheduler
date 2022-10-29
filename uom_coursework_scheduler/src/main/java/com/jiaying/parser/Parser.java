package com.jiaying.parser;

import com.jiaying.configuration.Configuration;
import com.jiaying.resource.Resource;

public interface Parser {
	Configuration parse(Resource resource);
}
