package com.jiaying.parser;

import java.util.ArrayList;

import org.json.JSONArray;
import com.jiaying.resource.Unit;

public interface Parser {
	ArrayList<Unit> parse(JSONArray courseunits);
}
