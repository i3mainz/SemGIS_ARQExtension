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
package de.hsmainz.cs.semgis.arqextension.raster;

import java.awt.geom.Rectangle2D;
import java.util.List;

import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.geometry.jts.JTS;


import com.hp.hpl.jena.sparql.engine.binding.Binding;
import com.hp.hpl.jena.sparql.expr.NodeValue;
import com.hp.hpl.jena.sparql.function.FunctionEnv;
import com.hp.hpl.jena.vocabulary.XSD;

import de.hsmainz.cs.semgis.arqextension.datatypes.GeoSPARQLLiteral;

public class Covers extends DoubleRaster2DSpatialFunction {

	@Override
	protected NodeValue exec(GridCoverage2D raster, GridCoverage2D raster2, GeoSPARQLLiteral datatype, Binding binding,
			List<NodeValue> evalArgs, String uri, FunctionEnv env) {
		   Rectangle2D bbox1=raster.getEnvelope2D().getBounds2D();
		   Rectangle2D bbox2=raster2.getEnvelope2D().getBounds2D();
		   return NodeValue.makeBoolean(JTS.toGeometry(bbox1.getBounds()).covers(JTS.toGeometry(bbox2.getBounds())));
		   
	}

	@Override
	protected String[] getRestOfArgumentTypes() {
		return new String[]{XSD.xint.getURI(),XSD.xint.getURI()};
	}

}
