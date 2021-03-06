/*******************************************************************************
 * Copyright (c) 2017 Timo Homburg, i3Mainz.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the BSD License
 * which accompanies this distribution, and is available at
 * https://directory.fsf.org/wiki/License:BSD_4Clause
 *
 * This project extends work by Ian Simmons who developed the Parliament Triple Store.
 * http://parliament.semwebcentral.org and published his work und BSD License as well.
 *
 *     
 *******************************************************************************/
package de.hsmainz.cs.semgis.arqextension;

import java.util.List;

import com.hp.hpl.jena.sparql.engine.binding.Binding;
import com.hp.hpl.jena.sparql.expr.NodeValue;
import com.hp.hpl.jena.sparql.function.FunctionEnv;
import com.hp.hpl.jena.vocabulary.XSD;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;

import de.hsmainz.cs.semgis.arqextension.datatypes.GeoSPARQLLiteral;

import com.vividsolutions.jts.geom.LineSegment;

public class Project extends SingleGeometrySpatialFunction {

	@Override
	protected NodeValue exec(Geometry g, GeoSPARQLLiteral datatype, Binding binding, List<NodeValue> evalArgs,
			String uri, FunctionEnv env) {
		Double distance=evalArgs.get(0).getDouble();
		Double azimuth=evalArgs.get(1).getDouble();
		//((LineSegment)g).pr
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getRestOfArgumentTypes() {
		// TODO Auto-generated method stub
		return new String[]{XSD.xdouble.getURI(),XSD.xdouble.getURI()};
	}

}
