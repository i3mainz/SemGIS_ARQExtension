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
package de.hsmainz.cs.semgis.arqextension.linestring;

import java.util.List;

import com.hp.hpl.jena.sparql.engine.binding.Binding;
import com.hp.hpl.jena.sparql.expr.NodeValue;
import com.hp.hpl.jena.sparql.function.FunctionEnv;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.operation.linemerge.LineMerger;

import de.hsmainz.cs.semgis.arqextension.datatypes.GeoSPARQLLiteral;
import de.hsmainz.cs.semgis.arqextension.geometry.ManyGeometrySpatialFunction;

public class MakeLine extends ManyGeometrySpatialFunction {

	@Override
	protected NodeValue exec(List<Geometry> geomlist, GeoSPARQLLiteral datatype, Binding binding,
			List<NodeValue> evalArgs, String uri, FunctionEnv env) {
		LineMerger linemerge=new LineMerger();
		linemerge.add(evalArgs);
		return makeNodeValue((Geometry)linemerge.getMergedLineStrings().iterator().next(), datatype);
	}


	@Override
	protected String[] getRestOfArgumentTypes() {
		return new String[] {};
	}

}
